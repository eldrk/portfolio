#define RED 1 // RED LED 값 (1 : on / 0 : off)
#define GREEN 2 // GREEN LED 값 (1 : on / 0 : off)
#define CLOCK 3 // LED 값 설정 주기 
#define BRIGHT 4 // 디스플레이 on/off 여부를 알림 (1 : off / 0 : on)
#define RESET 5 
#define SELECT 0
#define BRT_W 9 //밝기에 관한 핀
#define BRT_CL 10 //밝기에 관한 핀
#define BRIGHTd 6
#define SELECTd 7
#define FLAG 13

byte heartF_1[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x02, 0x40, 0x07, 0xE0,
0x03, 0xC0, 0x01, 0x80, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0
};

byte heartF_2[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x06, 0x60, 0x0F, 0xF0, 0x0F, 0xF0,
0x0F, 0xF0, 0x07, 0xE0, 0x03, 0xC0, 0x01, 0x80, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0
};

byte heartF_3[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0E, 0x70, 
0x1F, 0xF8, 0x3F, 0xFC, 0x3F, 0xFC, 0x3F, 0xFC,
0x3F, 0xFC, 0x1F, 0xF8, 0x0F, 0xF0, 0x07, 0xE0, 
0x03, 0xC0, 0x01, 0x80, 0x0, 0x0, 0x0, 0x0
};

byte heartF_4[32] = {
0x0, 0x0, 0x1C, 0x38, 0x3E, 0x7C, 0x7F, 0xFE, 
0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
0x7F, 0xFE, 0x3F, 0xFC, 0x1F, 0xF8, 0x0F, 0xF0, 
0x07, 0xE0, 0x03, 0xC0, 0x01, 0x80, 0x0, 0x0
};

// 라인 하트

byte heartL_2[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x06, 0x60, 0x0D, 0xB0, 0x08, 0x10,
0x0C, 0x30, 0x06, 0x60, 0x03, 0xC0, 0x01, 0x80, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0
};


byte heartL_3[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0E, 0x70, 
0x1F, 0xF8, 0x39, 0x9C, 0x30, 0x0C, 0x30, 0x0C,
0x30, 0x0C, 0x18, 0x18, 0x0C, 0x30, 0x06, 0x60, 
0x03, 0xC0, 0x01, 0x80, 0x0, 0x0, 0x0, 0x0
};

// 가운데 비어있는 하트

byte heart_2[32] = {
0x0, 0x0, 0x1C, 0x38, 0x3E, 0x7C, 0x7F, 0xFE, 
0xFF, 0xFF, 0xFF, 0xFF, 0xFD, 0xBF, 0xF8, 0x1F,
0x7C, 0x3E, 0x3E, 0x7C, 0x1F, 0xF8, 0x0F, 0xF0, 
0x07, 0xE0, 0x03, 0xC0, 0x01, 0x80, 0x0, 0x0
};

byte heart_3[32] = {
0x0, 0x0, 0x1C, 0x38, 0x3E, 0x7C, 0x7F, 0xFE, 
0xFF, 0xFF, 0xF9, 0x9F, 0xF0, 0x0F, 0xF0, 0x0F,
0x70, 0x0E, 0x38, 0x1C, 0x1C, 0x38, 0x0E, 0x70, 
0x07, 0xE0, 0x03, 0xC0, 0x01, 0x80, 0x0, 0x0
};

byte heart_4[32] = {
0x0, 0x0, 0x1C, 0x38, 0x3E, 0x7C, 0x73, 0xCE, 
0xE1, 0x87, 0xC0, 0x03, 0xC0, 0x03, 0xC0, 0x03,
0x60, 0x06, 0x30, 0x0C, 0x18, 0x18, 0x0C, 0x30, 
0x06, 0x60, 0x03, 0xC0, 0x01, 0x80, 0x0, 0x0
};

byte heart_5[32] = {
0x0, 0x0, 0x1C, 0x38, 0x22, 0x44, 0x41, 0x82, 
0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01,
0x40, 0x02, 0x20, 0x04, 0x10, 0x08, 0x08, 0x10, 
0x04, 0x20, 0x02, 0x40, 0x01, 0x80, 0x0, 0x0
};

byte _end[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0
};

byte cut_1[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x01, 0x80, 0x01, 0x80
};

byte cut_2[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80
};

byte cut_3[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
0x0, 0x0, 0x0, 0x0, 0x01, 0x80, 0x01, 0x80, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80
};

byte cut_4[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80
};

byte cut_4_1[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 
0x01, 0x80, 0x01, 0x80, 0x0, 0x0, 0x0, 0x0
};

byte cut_4_2[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0
};

byte cut_4_3[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
0x01, 0x80, 0x01, 0x80, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0
};

byte cut_5[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x01, 0x80, 0x01, 0x80,
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80
};

byte cut_6[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80,
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80
};

byte cut_7[32] = {
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80,
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80
};

byte cut_8[32] = {
0x0, 0x0, 0x0, 0x0, 0x01, 0x80, 0x01, 0x80, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80,
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80
};

byte cut_9[32] = {
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80,
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80
};

byte cut_10[32] = {
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80,
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0
};

byte cut_11[32] = {
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80,
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0
};

byte cut_12[32] = {
0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 0x01, 0x80, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0
};

byte cut_13[32] = {
0x01, 0x80, 0x01, 0x80, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0
};

//74hc595 RegisterPins number 0-95 individual control, melody

int SER_Pin = 8;   //pin 14 on the 75HC595
int RCLK_Pin = 9;  //pin 12 on the 75HC595
int SRCLK_Pin = 10; //pin 11 on the 75HC595

//How many of the shift registers - change this
#define number_of_74hc595s 12 

//do not touch
#define numOfRegisterPins number_of_74hc595s * 8

boolean registers[numOfRegisterPins];

void setup() {
  // 도트 매트릭스 셋업
  pinMode(RED, OUTPUT);
  pinMode(GREEN, OUTPUT);
  pinMode(CLOCK, OUTPUT);
  pinMode(BRIGHT, OUTPUT);
  pinMode(BRIGHTd, OUTPUT);
  pinMode(RESET, OUTPUT);
  pinMode(SELECT, OUTPUT);
  pinMode(SELECTd, OUTPUT);
  pinMode(BRT_W, OUTPUT);
  pinMode(BRT_CL, OUTPUT);
  pinMode(FLAG, INPUT);
  
  // 삼색 LED 셋업
  pinMode(SER_Pin, OUTPUT);
  pinMode(RCLK_Pin, OUTPUT);
  pinMode(SRCLK_Pin, OUTPUT);
  // 모든 레지스터 핀을 리셋한다
  clearRegisters();
  writeRegisters();
}
// 74HC595
//set all register pins to LOW
void clearRegisters(){
  for(int i = numOfRegisterPins - 1; i >=  0; i--){
     registers[i] = HIGH;
  }
}
//Set and display registers
//Only call AFTER all values are set how you would like (slow otherwise)
void writeRegisters(){

  digitalWrite(RCLK_Pin, LOW);

  for(int i = numOfRegisterPins - 1; i >=  0; i--){
    digitalWrite(SRCLK_Pin, LOW);

    int val = registers[i];

    digitalWrite(SER_Pin, val);
    digitalWrite(SRCLK_Pin, HIGH);

  }
  digitalWrite(RCLK_Pin, HIGH);

}

//set an individual pin HIGH or LOW
void setRegisterPin(int index, int value){
  registers[index] = value;
} 

void loop() {
  int start = digitalRead(FLAG);
  if(start==HIGH){


  
    
  LED_ON_D(cut_1, 3, 3);
  LED_ON_D(cut_2, 3, 3);
  LED_ON_D(cut_3, 3, 3);
  LED_ON_D(cut_4, 3, 3);
  LED_ON_D(cut_5, 3, 3);
  LED_ON_D(cut_6, 3, 3);
  LED_ON_D(cut_7, 3, 3);
  LED_ON_D(cut_8, 3, 3);
  LED_ON_D(cut_9, 3, 3);
  LED_ON(cut_1, 3, 3);
  LED_ON_D(cut_10, 3, 3);
  LED_ON(cut_2, 3, 3);
  LED_ON_D(cut_11, 3, 3);
  LED_ON(cut_3, 3, 3);
  LED_ON_D(cut_12, 3, 3);
  LED_ON(cut_4, 3, 3);
  LED_ON_D(cut_13, 3, 3);
  LED_ON_D(_end, 3, 1);
  LED_ON(cut_4_1, 3, 3);
  LED_ON(cut_4_2, 2, 3);
  LED_ON(cut_4_3, 2, 3);
 
  LED_ON(heartF_1, 5, 1);
  LED_ON(heartF_2, 5, 3);
  LED_ON(heartF_3, 5, 2);
  LED_ON(heartF_4, 5, 1); 
  LED_ON(heart_2, 5, 1);
  LED_ON(heart_3, 5, 1);
  LED_ON(heart_4, 5, 1);
  LED_ON(heart_5, 5, 1);  
  LED_ON(_end, 5, 1);

  LED_ON(heartF_1, 3, 1);
  LED_ON(heartF_2, 3, 3);
  LED_ON(heartF_3, 3, 2);
  LED_ON(heartF_4, 3, 1); 
  LED_ON(heart_2, 3, 1);
  LED_ON(heart_3, 3, 1);
  LED_ON(heart_4, 3, 1);
  LED_ON(heart_5, 3, 1);  
  LED_ON(_end, 5, 1);

  LED_ON(heartF_1, 3, 1);
  LED_ON(heartF_2, 3, 3);
  LED_ON(heartF_3, 3, 2);
  LED_ON(heartF_4, 3, 1); 
  LED_ON(heart_2, 3, 1);
  LED_ON(heart_3, 3, 1);
  LED_ON(heart_4, 3, 1);
  LED_ON(heart_5, 3, 1);  
  LED_ON(_end, 5, 1);

    setColor1(1,1,1);
    setColor2(1,1,1);
    setColor3(1,1,1);
    setColor4(1,1,1);
    setColor5(1,1,1);
    writeRegisters();
    delay(100);
  
    setColor1(0, 0, 0); 
    writeRegisters();
    delay(200);

    setColor2(0, 0, 0); 
    writeRegisters();
    delay(200);

    setColor3(0, 0, 0); 
    writeRegisters();
    delay(200);

    setColor4(0, 0, 0); 
    writeRegisters();
    delay(200);

    setColor5(0, 0, 0); 
    writeRegisters();
    delay(200);

  LED_ON_D(heartF_1, 3, 1);
  LED_ON_D(heartF_2, 3, 3);
  LED_ON_D(heartF_3, 3, 2);
  LED_ON_D(heartF_4, 3, 1); 
  LED_ON_D(heart_2, 3, 1);
  LED_ON_D(heart_3, 3, 1);
  LED_ON_D(heart_4, 3, 1);
  LED_ON_D(heart_5, 3, 1);  
  LED_ON_D(_end, 5, 1);

    setColor1(0,1,0);
    writeRegisters();
    delay(200);
    setColor2(1,0,0);
    writeRegisters();
    delay(200);
    setColor3(0,0,1);
    writeRegisters();
    delay(200);
    setColor4(0,1,0);
    writeRegisters();
    delay(200);
    setColor5(1,0,0);
    writeRegisters();
    delay(200);
    
  LED_ON(heartF_1, 3, 1);
  LED_ON(heartF_2, 3, 3);
  LED_ON(heartF_3, 3, 2);
  LED_ON(heartF_4, 3, 1); 
  LED_ON(heart_2, 3, 1);
  LED_ON(heart_3, 3, 1);
  LED_ON(heart_4, 3, 1);
  LED_ON(heart_5, 3, 1);  
  LED_ON(_end, 5, 1);

  LED_ON_D(heartF_1, 3, 1);
  LED_ON_D(heartF_2, 3, 3);
  LED_ON_D(heartF_3, 3, 2);
  LED_ON_D(heartF_4, 3, 1); 
  LED_ON_D(heart_2, 3, 1);
  LED_ON_D(heart_3, 3, 1);
  LED_ON_D(heart_4, 3, 1);
  LED_ON_D(heart_5, 3, 1);  
  LED_ON_D(_end, 5, 1);
  
    setColor1(0,0,1);
    writeRegisters();
    delay(200);
    setColor2(0,1,0);
    writeRegisters();
    delay(200);
    setColor3(1,0,0);
    writeRegisters();
    delay(200);
    setColor4(0,0,1);
    writeRegisters();
    delay(200);
    setColor5(0,1,0);
    writeRegisters();
    delay(200);
     
    /*setColor1(1,0,0);
    writeRegisters();
    delay(200);
    setColor2(0,0,1);
    writeRegisters();
    delay(200);
    setColor3(0,1,0);
    writeRegisters();
    delay(200);
    setColor4(1,0,0);
    writeRegisters();
    delay(200);
    setColor5(0,0,1);
    writeRegisters();
    delay(200);*/

    setColor1(1, 1, 1); 
    writeRegisters();
    delay(200);

    setColor2(1, 1, 1); 
    writeRegisters();
    delay(200);

    setColor3(1, 1, 1); 
    writeRegisters();
    delay(200);

    setColor4(1, 1, 1); 
    writeRegisters();
    delay(200);

    setColor5(1, 1, 1); 
    writeRegisters();
    delay(200);
  }
}
// 도트 매트릭스 실행 함수
void LED_ON(byte *Led, int time, int select) //*LED(배열의 포인터), time(시간), select(표현색)
{
int a = 0;
while(a < time){ //time이 높을수록 반복횟수가 많아짐 = 지정한 LED모양의 지속시간

//도트매트릭스를 사용하기 위한 준비
digitalWrite(RESET, HIGH);
digitalWrite(BRIGHT, HIGH);
digitalWrite(RESET, LOW);
digitalWrite(BRIGHT, LOW);
digitalWrite(SELECT, HIGH);

int num=0, count=0; //num배열크기[32]를 0~32까지 증가시킴
for(int j = 0 ; j < 16 ; j++) //LED16개 마다 BRIGHT신호를 주어야 함 총줄 16줄
{
digitalWrite(BRIGHT, HIGH); //16개를 사용하기전 HIGH값을 줌 시작신호
count=0; 
//바이너리 코드는 비트가 8개 있으므로 16개를 사용하기위에 8 X 2 두번을 돌림 
while(count <= 1) 
{
for(byte mask = 10000000 ; mask > 0 ; mask >>=1) //BitMask를 하기위한 for문
{ 
if(select == 1) //LED를 빨간색으로 표현할떄 
{
if(Led[num] & mask) //포인터로 가르키는 배열의 안에 바이너리를 비교[0~31]
{
digitalWrite(RED,HIGH); //0이 아니면 LED_ON
}
else
{
digitalWrite(RED,LOW); //0이면 LED_OFF
}
digitalWrite(CLOCK,1); 
digitalWrite(CLOCK,0);
}

if(select == 2) //LED를 녹색으로 표현할떄 
{
if(Led[num] & mask) //포인터로 가르키는 배열의 안에 바이너리를 비교[0~31]
{
digitalWrite(GREEN,HIGH);//0이 아니면 LED_ON
}
else
{
digitalWrite(GREEN,LOW); //0이면 LED_OFF
}
digitalWrite(CLOCK,1); 
digitalWrite(CLOCK,0);
}

if(select == 3) //LED를 빨간색+녹색(주황색) 으로 표현할떄 
{
if(Led[num] & mask) //포인터로 가르키는 배열의 안에 바이너리를 비교[0~31]
{
//0이 아니면 LED_ON
digitalWrite(RED,HIGH); 
digitalWrite(GREEN,HIGH);
}
else
{
//0이면 LED_OFF
digitalWrite(RED,LOW); 
digitalWrite(GREEN,LOW);
}
digitalWrite(CLOCK,1); 
digitalWrite(CLOCK,0);
}
}
num++; //배열이름[32]안에 있는 내용을 가져오기 위해서 0번지부터 31번지까지 바이너리 값을
//가져오게 함 번지수를 늘려줌
count++; //while를 2번돌기 위한 카운트증가
}

digitalWrite(BRIGHT, LOW); //16개의 LED를 제어했으면 BRIGHT LOW

for(int k = 0 ; k < 48 ; k++) //켜진 LED의 밝기를 증가
{
digitalWrite(BRT_W, HIGH);
digitalWrite(BRT_CL, HIGH);
digitalWrite(BRT_CL, LOW);
digitalWrite(BRT_W, LOW);
}

}
digitalWrite(SELECT, LOW);
a++;//지속시간에 관련된 변수
}
}

void LED_ON_D(byte *Led, int time, int select) //*LED(배열의 포인터), time(시간), select(표현색)
{
int a = 0;
while(a < time){ //time이 높을수록 반복횟수가 많아짐 = 지정한 LED모양의 지속시간

//도트매트릭스를 사용하기 위한 준비
digitalWrite(RESET, HIGH);
digitalWrite(BRIGHTd, HIGH);
digitalWrite(RESET, LOW);
digitalWrite(BRIGHTd, LOW);
digitalWrite(SELECTd, HIGH);

int num=0, count=0; //num배열크기[32]를 0~32까지 증가시킴
for(int j = 0 ; j < 16 ; j++) //LED16개 마다 BRIGHT신호를 주어야 함 총줄 16줄
{
digitalWrite(BRIGHTd, HIGH); //16개를 사용하기전 HIGH값을 줌 시작신호
count=0; 
//바이너리 코드는 비트가 8개 있으므로 16개를 사용하기위에 8 X 2 두번을 돌림 
while(count <= 1) 
{
for(byte mask = 10000000 ; mask > 0 ; mask >>=1) //BitMask를 하기위한 for문
{ 
if(select == 1) //LED를 빨간색으로 표현할떄 
{
if(Led[num] & mask) //포인터로 가르키는 배열의 안에 바이너리를 비교[0~31]
{
digitalWrite(RED,HIGH); //0이 아니면 LED_ON
}
else
{
digitalWrite(RED,LOW); //0이면 LED_OFF
}
digitalWrite(CLOCK,1); 
digitalWrite(CLOCK,0);
}

if(select == 2) //LED를 녹색으로 표현할떄 
{
if(Led[num] & mask) //포인터로 가르키는 배열의 안에 바이너리를 비교[0~31]
{
digitalWrite(GREEN,HIGH);//0이 아니면 LED_ON
}
else
{
digitalWrite(GREEN,LOW); //0이면 LED_OFF
}
digitalWrite(CLOCK,1); 
digitalWrite(CLOCK,0);
}

if(select == 3) //LED를 빨간색+녹색(주황색) 으로 표현할떄 
{
if(Led[num] & mask) //포인터로 가르키는 배열의 안에 바이너리를 비교[0~31]
{
//0이 아니면 LED_ON
digitalWrite(RED,HIGH); 
digitalWrite(GREEN,HIGH);
}
else
{
//0이면 LED_OFF
digitalWrite(RED,LOW); 
digitalWrite(GREEN,LOW);
}
digitalWrite(CLOCK,1); 
digitalWrite(CLOCK,0);
}
}
num++; //배열이름[32]안에 있는 내용을 가져오기 위해서 0번지부터 31번지까지 바이너리 값을
//가져오게 함 번지수를 늘려줌
count++; //while를 2번돌기 위한 카운트증가
}

digitalWrite(BRIGHTd, LOW); //16개의 LED를 제어했으면 BRIGHT LOW

for(int k = 0 ; k < 48 ; k++) //켜진 LED의 밝기를 증가
{
digitalWrite(BRT_W, HIGH);
digitalWrite(BRT_CL, HIGH);
digitalWrite(BRT_CL, LOW);
digitalWrite(BRT_W, LOW);
}

}
digitalWrite(SELECTd, LOW);
a++;//지속시간에 관련된 변수
}
}

// 3색 LED colorSet
void setColor1(int red, int green, int blue) {
  setRegisterPin(0, red);
  setRegisterPin(1, green);
  setRegisterPin(2, blue);

}
void setColor2(int red, int green, int blue) {
  setRegisterPin(4, red);
  setRegisterPin(5, green);
  setRegisterPin(6, blue);
}
void setColor3(int red, int green, int blue) {
  setRegisterPin(8, red);
  setRegisterPin(9, green);
  setRegisterPin(10, blue);
}
void setColor4(int red, int green, int blue) {
  setRegisterPin(13, red);
  setRegisterPin(14, green);
  setRegisterPin(15, blue);
}
void setColor5(int red, int green, int blue) {
  setRegisterPin(16, red);
  setRegisterPin(17, green);
  setRegisterPin(18, blue);
}
