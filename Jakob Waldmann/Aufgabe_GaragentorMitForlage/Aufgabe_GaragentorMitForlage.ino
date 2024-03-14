/*
Name: 
Datum: 07.09.2023
Aufgabe: Abi Musteraufgabe Garagentorsteuerung 
         nach Vorlage UML-Zustandsdiagramm
Controller: NUCLEO64 L152RE

Anschlüsse Bedienfeld:
TorOeffnen       PC0 (Digital Input, hier Low aktiv, PullUp)
TorSchliessen    PC1 (Digital Input, hier Low aktiv, PullUp)  
Geschwindigkeit  PB15 (Analog Input, Poti 3,3V)
LCD Anzeige      I2C (PB8=SCL, PB9=SDA)

Anschlüsse Garagentor:
Warnleuchte      PB0 (Digital Output)
heben            PC8 (PWM)
senken           PC9 (PWM)
EndschalterOffen PC4 (Digital Input, DIP-Schalter, PullUp)
EndschalterZu    PC5 (Digital Input, DIP-Schalter, PullUp)
Lichtschranke    PC7 (Ex-IR, DIP-Schalter, PullUp), fallende Flanke
*/

#include <Wire.h>                   //I2C Library
#include <LiquidCrystal_PCF8574.h>  //LCD Library
LiquidCrystal_PCF8574 lcd(0x27);    //LCD Library I2C-Adresse

//Zustände
#define Init 0
#define Geschlossen 1
#define Oeffnen 2
#define Offen 3
#define Schliessen 4
#define Gestoppt 5
int Zustand=Init;

#define TorOeffnen PC0
#define TorSchliessen PC1
#define Geschwindigkeit PB15
 
#define Warnleuchte PB0
#define heben PC8
#define senken PC9
#define EndschalterOffen PC4
#define EndschalterZu PC5
#define Lichtschranke PC7

static HardwareTimer mytimer = HardwareTimer(TIM2); //Beachte: TIM3 geht nicht, da für PWM benutzt wird!!!
char *Text[]={"   Tor-offen  ","     Tor-zu    ","  Tor-gestoppt  ","   Tor-faehrt  "};   //* ist erforderlich!!!

//-------------------------------------------
void setup() 
{
  pinMode(TorOeffnen, INPUT_PULLUP);
  pinMode(TorSchliessen, INPUT_PULLUP);
  pinMode(Geschwindigkeit, INPUT);

  pinMode(Warnleuchte, OUTPUT);
  pinMode(heben, OUTPUT);
  pinMode(senken, OUTPUT);
  pinMode(EndschalterOffen, INPUT_PULLUP);
  pinMode(EndschalterZu, INPUT_PULLUP);
  pinMode(Lichtschranke, INPUT_PULLUP);

  analogReadResolution(12);  //default 10Bit ADC -> 4095
  analogWriteResolution(12);
  analogWriteFrequency(10000); //10kHz

  mytimer.setOverflow(1000, MICROSEC_FORMAT);  //1ms
  mytimer.setPrescaleFactor(500);    //500x1ms = 500ms = 0,5s
  mytimer.attachInterrupt(ISR_Timer);

  attachInterrupt(digitalPinToInterrupt(Lichtschranke),ISR_schnellstopp,FALLING);

  lcd.begin(16,2);            //LCD mit 16x2 Zeichen
  lcd.clear();                //Display löschen
  lcd.setBacklight(255);      //maximale Hindergrundbeleuchtung
  lcd.setCursor(0,0);         //Cursor setzen Spalte(0 bis 15),Zeile(0,1)
  lcd.print("-- Garagentor --"); //Text auf oberen Zeile
}

void loop(){
  switch(Zustand){
    case Init: Zustand = Geschlossen;
    motorstop();
    lcdOut(Text[1]);
    break;
    
    case Geschlossen:
    if(digitalRead(TorOeffnen) == 0){
      Zustand = Oeffnen;
      blinckenEin();
      lcdOut(Text[3]);
    }
    break;
    
    case Oeffnen:
    oeffnen();
    if(analogRead(EndschalterOffen) == HIGH){
      motorstop();
      lcdOut(Text[0]);
      digitalWrite(Warnleuchte, LOW);
      blinckenAus();
      Zustand = Offen;
    }
    break;
    
    case Offen:
    if(analogRead(TorSchliessen) == 0){
      blinckenEin();
      lcdOut(Text[3]);
      Zustand = Schliessen;
    }
    break;
    
    case Schliessen:
    schliessen();
    if(analogRead(EndschalterZu) == 1){
      Zustand = Geschlossen;
      motorstop();
      blinckenAus();
      lcdOut(Text[1]);
    }
    break;
    
    case Gestoppt:
    motorstop();
    if(analogRead(TorSchliessen) == 1){
      Zustand = Schliessen;
      lcdOut(Text[3]);
      Zustand = Schliessen;
    }

    if(analogRead(TorOeffnen) == 1){
       lcdOut(Text[3]);
       blinckenEin();
    }
    break;
  }
}

void oeffnen(){
  
}

void schliessen(){
  
}

void blinckenEin(){
  mytimer.resume();
}

void blinckenAus(){
  mytimer.pause();
  digitalWrite(Warnleuchte, LOW);
}

void motorstop(){

}

void lcdOut(String s){
  lcd.setCursor(0,1);
  lcd.print(s);
}

void ISR_Timer(){
  digitalToggle(Warnleuchte);
}

void ISR_schnellstopp(){
  lcdOut(Text[2]);
  doppelteFrequenz();
}

void normaleFrequenz(){
  mytimer.setPrescaleFactor(500); //500ms
}

void doppelteFrequenz(){
  mytimer.setPrescaleFactor(250); //250ms
}
