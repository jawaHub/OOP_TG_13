/*
   Name: Jakob Waldmann
   Klasse: 13/3
   Gruppe: B
   Datum: 11.09.2023
   Aufgabe: Parkhaus

*/

#define PE PB0  //Parkkartenentnahem
#define ES PB1  //Signal Einfahrtssensor
#define LS PB4  //Lichtschranke
#define UN PB6  //Unten
#define OB PB7  //Oben
#define Mauf PC7  //Motor auf
#define Mab PC0   //Motor ab

#define Schranke_unten 0
#define Schranke_hoch 1
#define Schranke_oben 2
#define Schranke_runter 3

int Zustand = Schranke_unten;

void setup() {
  INIT();
  attachInterrupt(digitalPinToInterrupt(LS), ISR_LS, RISING);

  pinMode(Mauf, OUTPUT);
  pinMode(Mab, OUTPUT);
}

void loop() {
  switch (Zustand) {
    case Schranke_unten: 
      digitalWrite(Mab, 0);
      digitalWrite(Mauf, 0);
      if (digitalRead(PE) == 0)Zustand = Schranke_hoch; 
      break;
    case Schranke_hoch: 
      digitalWrite(Mauf, 1);
      if (digitalRead(OB) == 1)Zustand = Schranke_oben; 
      break;
    case Schranke_oben: 
      digitalWrite(Mab, 0);
      digitalWrite(Mauf, 0);
      if (digitalRead(ES) == 0 && digitalRead(LS) == 0)Zustand = Schranke_runter; 
      break;
    case Schranke_runter: 
      digitalWrite(Mab, 1);
      if (digitalRead(UN) == 1)Zustand = Schranke_unten; 
      break;
  }
}

void ISR_LS() {
  if(Zustand = Schranke_runter) Zustand = Schranke_hoch;
}
