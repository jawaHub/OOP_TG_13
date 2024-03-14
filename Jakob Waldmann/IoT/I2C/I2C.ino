/*
 * Jakob Waldmann
 * 04.03.2024
 * SDA PB9
 * SCL PB8
 * Potin an GND, 3.3V, Mitte bei A0
 */

/*
 * Slave Code:
 * #include <Wire.h>;
 * #define LED 26
 * volatile byte Empfangswert
 * 
 * void setup(){
 *  Wire.begin(9);
 *  Wire.onReceive(Datenempfang);
 *  pinMode(LED, OUTPUT);
 * }
 * 
 * void loop(){
 *  analogWrite(LED, Empfangswert);
 * }
 * 
 * void Datenempfang(int Anzahl){
 *  if(Wire.available()) Empfangswert = Wire.read();
 * }
 * 
 */
#include <Wire.h>;
int Drehregler = 0; //Poti

void setup() {
  pinMode(Drehregler, INPUT);
  Wire.begin();
}

void loop() {
  Drehregler = analogRead(A0);  //Poti 0V bis 5V -> 10Bit 0 bis 1023
  Drehregler /= 4;              // 0 bis 255
  Wire.beginTransmission(9);
  Wire.write(100);
  Wire.endTransmission();
  delay(100);
}
