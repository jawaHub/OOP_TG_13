void INIT(void)
{
 int PORT_BL[] = {PB0,PB1,PB2,PB3,PB4,PB5,PB6,PB7}; //Taster und Schalter  
 int PORT_CL[] = {PC0,PC1,PC2,PC3,PC4,PC5,PC6,PC7}; //8 LEDs 
 for(int i = 0;i<8;i++)
 {
  
  
  pinMode(PORT_BL[i],INPUT);
  pinMode(PORT_CL[i],OUTPUT);
  
  }

  
}
