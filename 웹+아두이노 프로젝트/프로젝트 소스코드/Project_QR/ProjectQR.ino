#include "ESP8266.h"
#include<Servo.h>

#define SSID        "MULTI_GUEST"
#define PASSWORD    "guest1357"
#define PORT        8080
#define TIMEOUT     10

Servo myservo;
SoftwareSerial mySerial(2, 3);
ESP8266 wifi(mySerial);

void setup(void)
{
    Serial.begin(9600);
    Serial.print("setup begin\r\n");
    
    Serial.print("FW Version :");
    Serial.println(wifi.getVersion().c_str());

    // 모듈을 station+ap모드로 설정한다
    if (wifi.setOprToStationSoftAP()) {
        Serial.print("to station + softap ok\r\n");
    } else {
        Serial.print("to station + softap err\r\n");
    }

    // ssid와 password로 ap에 접속한다
    if (wifi.joinAP(SSID, PASSWORD)) {
        Serial.print("Join AP success\r\n");
        Serial.print("AP IP : ");
        // 아두이노+esp8266모듈의 IP주소를 보여준다
        Serial.println(wifi.getLocalIP().c_str());    
    } else {
        Serial.print("Join AP failure\r\n");
    }

    // 서버가 여러 클라이언트의 접속을 받을 수 있도록 설정한다
    if (wifi.enableMUX()) {
        Serial.print("multiple ok\r\n");
    } else {
        Serial.print("multiple err\r\n");
    }

    // 서버를 기동한다
    if (wifi.startTCPServer(PORT)) {
        Serial.print("start tcp server ok\r\n");
    } else {
        Serial.print("start tcp server err\r\n");
    }

    // 서버의 TIMEOUT을 설정한다
    if (wifi.setTCPServerTimeout(TIMEOUT)) { 
        Serial.print("set tcp server timout 10 seconds\r\n");
    } else {
        Serial.print("set tcp server timout err\r\n");
    }
    
    Serial.print("setup end\r\n");
    
    pinMode(8, OUTPUT);
    pinMode(9, OUTPUT);
    digitalWrite(8,LOW);
    digitalWrite(9,LOW);
    myservo.attach(13);
}
 
void loop(void)
{
    uint8_t buffer[200] = {0};
    uint8_t mux_id;
    // 서버가 데이터를 받았을 경우
    uint32_t len = wifi.recv(&mux_id, buffer, sizeof(buffer), 100);
    if (len > 0) {

        digitalWrite(8,HIGH);
        digitalWrite(9,HIGH);
        delay(1200);
        Serial.print("HIGH = ");
        Serial.println(digitalRead(9));
        
        digitalWrite(8, LOW);
        digitalWrite(9, LOW);
        Serial.print("LOW = ");
        Serial.println(digitalRead(9));
        delay(100);
        
        Serial.print("Received from : ");
        Serial.print(mux_id);
        Serial.println(" [");

        // 받은 데이터를 출력
        String str = "";
        for(uint32_t i = 0; i < len; i++) {
            str += (char)buffer[i];
        }
        Serial.println(str);
        /*
        // 받은 데이터에서 name 값을 split
        int pos_1st = str.indexOf(" ");
        int pos_2nd = str.indexOf(" ", pos_1st+1);
        String str_split = str.substring(pos_1st+1, pos_2nd);
        Serial.print(str_split);
        //*/
        
        Serial.print("]\r\n");
          
        Serial.print("Status: [");
        Serial.print(wifi.getIPStatus().c_str());
        Serial.println("]");
        char *msg = "HTTP/1.1 302 Found\r\nContent-Type: text/html; charset=utf-8\r\nCache-Control: no-cache, no-store, must-revalidate\r\nLocation: http://70.12.110.55:8080/projectqr/\r\n\r\n";
        if(wifi.send(mux_id, (const uint8_t*)msg, len)) {
            Serial.print("send back ok\r\n");
        } else {
            Serial.print("send back err\r\n");
        }

        // 클라이언트와 TCP 연결을 해체한다
        if (wifi.releaseTCP(mux_id)) {
            Serial.print("release tcp ");
            Serial.print(mux_id);
            Serial.println(" ok");
        } else {
            Serial.print("release tcp ");
            Serial.print(mux_id);
            Serial.println(" err");
        }
        delay(3000);
    }

    //서보 동작
    if(digitalRead(12)==HIGH){
      myservo.attach(13);
      Serial.println("servo start");
      for(int i = 0; i <=180; ++i){
        myservo.write(i);
        delay(2);
      }
      myservo.write(0);
      delay(500);
      myservo.detach();
      delay(500);
    }    
}
