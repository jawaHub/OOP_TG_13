void INIT(void){
  int PORT_BO[] = {PB0,PB1,PB2,PB3}; //DIP-Schalter / Taster
  int PORT_BI[] = {PB4,PB5,PB6,PB7}; 
  int PORT_CL[] = {PC0,PC1,PC2,PC3,PC4,PC5,PC6,PC7}; // LEDS
  
  for(int i=0; i<8; i++){ //sizeof(PORT_BL)/sizeof(PORT_BL[0])
    pinMode(PORT_CL[i], OUTPUT);
  }
  for(int i=0; i<4; i++){ //sizeof(PORT_BL)/sizeof(PORT_BL[0])
    pinMode(PORT_BO[i], INPUT_PULLUP);
    pinMode(PORT_BI[i], INPUT_PULLUP);
  }
}
