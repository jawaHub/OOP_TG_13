//IT KA 
//Jakob Walmann
//11.03.2024


#define Zurück PB0
#define Sensor PB1
#define Not_Aus PB4
#define Ein_Aus PB7
#define IN1 PB8
#define IN2 PB9

int signalSensor;

enum Zustaende{
  AUS,
  VORWÄRTS,
  RÜCKWÄRTS,
  SENSOR_HALT
};

Zustaende zustand;
void setup() {
  pinMode(Zurück, INPUT_PULLUP);
  pinMode(Sensor, INPUT_PULLUP);
  pinMode(IN1, OUTPUT);
  pinMode(IN2, OUTPUT);
  pinMode(Not_Aus, INPUT_PULLUP);
  pinMode(Ein_Aus, INPUT_PULLUP);

  attachInterrupt(digitalPinToInterrupt(Sensor),sensorISR,FALLING);
  zustand = AUS;
  signalSensor = 0;
}

void loop() {
  switch (zustand){
    case AUS:
    aus();
    if(digitalRead(Ein_Aus) == HIGH && digitalRead(Not_Aus) == HIGH) zustand = VORWÄRTS;
    else if(digitalRead(Not_Aus) == LOW && digitalRead(Zurück) == LOW) zustand = RÜCKWÄRTS;
    signalSensor = 0;
    break;
    
    case VORWÄRTS:
    cw();
    if(signalSensor == 1) zustand = SENSOR_HALT;
    else if(digitalRead(Ein_Aus) == LOW || digitalRead(Not_Aus) == LOW) zustand = AUS;
    break;
    
    case RÜCKWÄRTS:
    ccw();
    if(digitalRead(Zurück) == HIGH) zustand = AUS;
    break;
    
    case SENSOR_HALT:
    aus();
    warten();
    zustand = VORWÄRTS;
    signalSensor = 0;
    break;
  }
}

void sensorISR(){
  signalSensor = 1;
}

void ccw(){
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, HIGH); 
}

void cw(){
  digitalWrite(IN1, HIGH);
  digitalWrite(IN2, LOW);
}

void aus(){
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, LOW);
}

void warten(){
  delay(3000);
}
