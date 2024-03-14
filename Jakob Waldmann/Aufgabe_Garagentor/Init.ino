void INIT(void){
  int PORT_B[] = {PB0,PB1,PB2,PB3,PB4,PB5,PB6,PB7}; //DIP-Schalter / Taster
  int PORT_C[] = {PC0,PC1,PC2,PC3,PC4,PC5,PC6,PC7};
  
  for(int i=0; i<8; i++){
    pinMode(PORT_C[i], INPUT);
    pinMode(PORT_B[i], OUTPUT);
  }
}
