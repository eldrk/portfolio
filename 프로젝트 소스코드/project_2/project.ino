#include "pitches.h"
#define MELODY_PIN 4
int sign = 2;
int melody[] = {
  NOTE_A4,
  NOTE_A4,
  NOTE_A4,
  NOTE_A4,
  NOTE_A4,
  NOTE_A4,
  NOTE_A4,
  NOTE_C5,
  NOTE_F4,
  NOTE_G4,
  NOTE_A4,
  0,
  NOTE_AS4,
  NOTE_AS4,
  NOTE_AS4,
  NOTE_AS4,
  NOTE_AS4,
  NOTE_A4,
  NOTE_A4,
  NOTE_A4,
  NOTE_C5,
  NOTE_C5,
  NOTE_AS4,
  NOTE_G4,
  NOTE_F4,
  0, 
};

int noteDurations[] = {
  2,2,4,2,2,4,2,2,3,1,6,2,
  2,2,3,1,2,2,2,2,2,2,2,2,6,2,
};

void setup() {
  // put your setup code here, to run once:
  pinMode(9,OUTPUT);
  pinMode(8,OUTPUT);
  pinMode(sign,INPUT);
  //attachInterrupt(digitalPinToInterrupt(sign),exchange,RISING);
  digitalWrite(8,LOW);
  Serial.begin(9600);
  
 }

void loop() {
  // put your main code here, to run repeatedly:
    Serial.println(digitalRead(sign));
    if(digitalRead(sign)==HIGH){
        digitalWrite(9,HIGH);
        analogWrite(10,200);
        sound();
        digitalWrite(9,LOW);
        delay(3000);
      } 
      delay(500);
   }

void sound(){
  for(int thisNote = 0; thisNote < (sizeof(melody) / sizeof(int)); thisNote++)
      {
        int noteDuration = 125 * noteDurations[thisNote];
        tone(MELODY_PIN, melody[thisNote], noteDuration);
    
        int pauseBetweenNotes = noteDuration * 1.20;
        delay(pauseBetweenNotes);
        noTone(MELODY_PIN);
      }
  }
  
  
