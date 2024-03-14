/*
   Name: Jakob Waldmann
   Klasse: 13/3
   Gruppe: B
   Datum: 16.10.2023
   Aufgabe: Garagentorsteuerung
*/

//Eingabe
#define Regler PC0
#define IN1 D3
#define IN2 D5
#define Lichtschranke PC4

#define TTorOeffnen PB8
#define TTorStoppen PB9
#define TTorSchliessen PB10

//Ausgabe
#define Oeffnet PB0
#define Offen PB1
#define Schliesst PB2
#define Geschlossen PB3
#define Gestoppt PB4
#define Warnleuchte PB5

//Zustände
#define TorOeffnen 0
#define TorOffen 1
#define TorSchliessen 2
#define TorGestoppt 3
#define TorGeschlossen 4

int Zustand;

void setup() {
  INIT();
  pinMode(Regler, INPUT);
  analogWriteResolution(10); //0-1023 als Ausgabe
  pinMode(IN1, OUTPUT);
  pinMode(IN2, OUTPUT);
  digitalWrite(IN1, 0);
  digitalWrite(IN2, 0);
  attachInterrupt(digitalPinToInterrupt(Lichtschranke), schnellstop, FALLING);
  Zustand = TorGeschlossen;
  GPIOB -> ODR = 0;

  schliessen();  
}

void loop() {
  if(digitalRead(TTorOeffnen) == LOW) Zustand = TorOeffnen;
  if(digitalRead(TTorSchliessen) == LOW) Zustand = TorSchliessen;
  switch(Zustand){
    case TorOeffnen:
    oeffnen();
    break;
    
    case TorOffen:
    break;
    
    case TorSchliessen:
    break;
    
    case TorGestoppt:
    break;
    
    case TorGeschlossen:
    break;
  }
  ausgabe();
}

void schliessen(){
  analogWrite(IN1, 0);
  //analogWrite(IN2, 500);
}

void oeffnen(){
  //analogWrite(IN1, 500);
  analogWrite(IN2, 0);
}

void ausgabe(){
  digitalWrite(PB0,LOW);
  digitalWrite(PB1,LOW);
  digitalWrite(PB2,LOW);
  digitalWrite(PB3,LOW);
  digitalWrite(PB4,LOW);
  digitalWrite(PB5,LOW);
  digitalWrite(PB6,LOW);
  digitalWrite(PB7,LOW);
    switch(Zustand){
      case TorOeffnen:
      digitalWrite(Offen, HIGH);
      break;
      
      case TorOffen:
      digitalWrite(Oeffnet, HIGH);
      break;
    
      case TorSchliessen:
      digitalWrite(Schliesst, HIGH);
      break;
    
      case TorGestoppt:
      digitalWrite(Gestoppt, HIGH);
      break;
    
      case TorGeschlossen:
      digitalWrite(Geschlossen, HIGH);
      break;
  }
}

void schnellstop() {
  Zustand = TorGestoppt;
}
