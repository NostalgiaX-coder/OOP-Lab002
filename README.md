
# Lab 02: Building Classes

## ข้อ 1: การออกแบบ AirPurifier Class

คลาส AirPurifier ใช้จำลองเครื่องฟอกอากาศที่สามารถเปิด–ปิดเครื่อง ปรับความเร็วพัดลม เก็บค่าฝุ่น PM2.5 และเก็บข้อมูลจำนวนเครื่องฟอกอากาศของแต่ละรุ่นได้

### 1.1 Instance Variables

ตัวแปรที่ใช้เก็บข้อมูลเฉพาะของแต่ละ Object

| ตัวแปร | Data Type | หน้าที่ |
|---|---|---|
| model | String | เก็บชื่อรุ่นของเครื่อง |
| serialNo | String | เก็บหมายเลขประจำเครื่อง |
| power | boolean | เก็บสถานะเปิด–ปิดเครื่อง |
| fanSpeed | int | เก็บระดับความเร็วพัดลม 0–3 |
| pm25 | double | เก็บค่าฝุ่น PM2.5 |

### 1.2 Instance Methods

เมธอดที่ใช้ควบคุมหรือเรียกดูข้อมูลของแต่ละ Object

| Method | หน้าที่ |
|---|---|
| turnOn() | เปิดเครื่องฟอกอากาศ |
| turnOff() | ปิดเครื่องฟอกอากาศ |
| setFanSpeed(int speed) | ปรับความเร็วพัดลม และปิดเครื่องเมื่อ speed เป็น 0 |
| setPM25(double value) | กำหนดค่าฝุ่น PM2.5 |
| isOn() | ตรวจสอบสถานะเปิด–ปิดเครื่อง |
| getFanSpeed() | คืนค่าความเร็วพัดลม |
| getPM25() | คืนค่าฝุ่น PM2.5 |
| showStatus() | แสดงข้อมูลทั้งหมดของเครื่อง |

### 1.3 Class Variables

ตัวแปรส่วนกลางของ Class ที่ใช้ร่วมกันระหว่างทุก Object โดยประกาศด้วย static

| ตัวแปร | Data Type | หน้าที่ |
|---|---|---|
| totalCount | static int | เก็บจำนวนเครื่องทั้งหมดที่สร้างขึ้น |
| modelCount | static int | เก็บจำนวนรุ่นที่แตกต่างกัน |
| modelCounts | static Map<String, Integer> | เก็บจำนวนเครื่องของแต่ละรุ่น |

### 1.4 Class Methods

เมธอดที่ใช้จัดการและคำนวณข้อมูลส่วนกลางของ Class โดยสามารถเรียกผ่านชื่อ Class ได้โดยตรง

| Method | หน้าที่ |
|---|---|
| getTotalCount() | คืนค่าจำนวนเครื่องทั้งหมด |
| getModelCount() | คืนค่าจำนวนรุ่นที่แตกต่างกัน |
| mostPopularModel() | คืนชื่อรุ่นที่มีจำนวนเครื่องมากที่สุด |
| averageCountPerModel() | คำนวณจำนวนเครื่องเฉลี่ยต่อรุ่น |

---

## ข้อ 2: หลักการทำงานของแต่ละ Method

### 2.1 Constructor

AirPurifier(String model, String serialNo)

Input:
- String model
- String serialNo

Process:
- กำหนดชื่อรุ่นและหมายเลขประจำเครื่อง
- กำหนด power เป็น false
- กำหนด fanSpeed เป็น 0
- กำหนด pm25 เป็น 0.0
- เพิ่ม totalCount ขึ้น 1
- ตรวจสอบว่าชื่อรุ่นมีอยู่ใน modelCounts หรือไม่
- หากเป็นรุ่นใหม่ ให้เพิ่ม modelCount ขึ้น 1
- เพิ่มจำนวนเครื่องของรุ่นนั้นใน modelCounts

Result:
- Object ของ AirPurifier ที่ได้รับการกำหนดค่าเริ่มต้นเรียบร้อยแล้ว
- ข้อมูลส่วนกลางของ Class ได้รับการอัปเดต

### 2.2 Instance Methods

| Method | Input | หลักการทำงาน | Return |
|---|---|---|---|
| turnOn() | ไม่มี | กำหนด power เป็น true และ fanSpeed เป็น 1 | void |
| turnOff() | ไม่มี | กำหนด power เป็น false และ fanSpeed เป็น 0 | void |
| setFanSpeed() | int speed | หากเครื่องเปิดอยู่และ speed อยู่ระหว่าง 1–3 ให้เปลี่ยนความเร็วพัดลม หาก speed เป็น 0 ให้ปิดเครื่อง กรณีอื่นจะไม่เปลี่ยนแปลงค่า | void |
| setPM25() | double value | ตรวจสอบว่าค่าฝุ่นไม่ติดลบ หากถูกต้องจึงบันทึกค่า | void |
| isOn() | ไม่มี | คืนค่าตัวแปร power | boolean |
| getFanSpeed() | ไม่มี | คืนค่าตัวแปร fanSpeed | int |
| getPM25() | ไม่มี | คืนค่าตัวแปร pm25 | double |
| showStatus() | ไม่มี | แสดงข้อมูล Instance Variables ทั้งหมดผ่าน Console | void |

### 2.3 Class Methods

| Method | Input | หลักการทำงาน | Return |
|---|---|---|---|
| getTotalCount() | ไม่มี | คืนค่าตัวแปร totalCount | int |
| getModelCount() | ไม่มี | คืนค่าตัวแปร modelCount | int |
| mostPopularModel() | ไม่มี | วนลูปตรวจสอบจำนวนเครื่องของแต่ละรุ่น แล้วคืนชื่อรุ่นที่มีจำนวนมากที่สุด หากไม่มีข้อมูลให้คืนค่า null | String |
| averageCountPerModel() | ไม่มี | นำ totalCount หารด้วย modelCount โดยใช้การหารแบบทศนิยม หากไม่มีข้อมูลให้คืนค่า 0.0 | double |

---

## ข้อ 3: การ Implement AirPurifier Class

สร้างคลาส AirPurifier ในไฟล์ AirPurifier.java โดยประกอบด้วย Instance Variables, Constructor และ Instance Methods ตามที่ออกแบบไว้ในข้อ 1 และข้อ 2

หลักการทำงานของโปรแกรม:

- เครื่องฟอกอากาศแต่ละเครื่องมีข้อมูลและสถานะเป็นของตัวเอง
- เมื่อสร้าง Object ใหม่ เครื่องจะอยู่ในสถานะปิด
- เมื่อเปิดเครื่อง พัดลมจะเริ่มทำงานที่ระดับ 1
- สามารถปรับความเร็วพัดลมได้ตั้งแต่ระดับ 1–3 เมื่อเครื่องเปิดอยู่
- เมื่อกำหนดความเร็วพัดลมเป็น 0 เครื่องจะปิดโดยอัตโนมัติ
- หากกำหนดความเร็วพัดลมนอกเหนือจากช่วงที่กำหนด จะไม่เปลี่ยนแปลงข้อมูล
- ไม่สามารถกำหนดค่าฝุ่น PM2.5 เป็นค่าติดลบได้
- สามารถเรียกดูสถานะและข้อมูลของแต่ละ Object ผ่าน Instance Methods ได้

---

## ข้อ 4: การสร้าง Object และทดสอบโปรแกรม

สร้างคลาส Lab02 ในไฟล์ Lab02.java ซึ่งมี main() สำหรับทดสอบการทำงานของ AirPurifier

### 4.1 ข้อมูล Object ที่ใช้ทดสอบ

| Object | Model | Serial Number |
|---|---|---|
| a | Pro | 001 |
| b | Standard | 002 |

### 4.2 Test Cases

| Test Case | ผลลัพธ์ที่คาดหวัง |
|---|---|
| สร้าง Object ใหม่ | power = false, fanSpeed = 0, pm25 = 0.0 |
| a.turnOn() | power = true, fanSpeed = 1 |
| a.setFanSpeed(3) | fanSpeed = 3 |
| a.setPM25(34.3) | pm25 = 34.3 |
| b.turnOn() | power = true, fanSpeed = 1 |
| b.setFanSpeed(2) | fanSpeed = 2 |
| b.setPM25(15.5) | pm25 = 15.5 |
| b.turnOff() | power = false, fanSpeed = 0 |
| a.setFanSpeed(10) | fanSpeed ยังคงเป็น 3 |
| a.setPM25(-5) | pm25 ยังคงเป็น 34.3 |
| a.isOn() | true |
| a.getFanSpeed() | 3 |
| a.getPM25() | 34.3 |
| a.setFanSpeed(0) | power = false, fanSpeed = 0 |

### 4.3 Expected Output

    Model: Pro
    Serial: 001
    Power: true
    Fan Speed: 3
    PM2.5 : 34.3
    ---------------------
    Model: Standard
    Serial: 002
    Power: false
    Fan Speed: 0
    PM2.5 : 15.5
    A is on: true
    A speed: 3
    A PM2.5: 34.3
    A is on: false
    A speed: 0

การทดสอบนี้ใช้ตรวจสอบว่า Instance Methods ทำงานตามที่ออกแบบไว้ และ Object แต่ละตัวสามารถจัดเก็บและเปลี่ยนแปลงข้อมูลได้อย่างอิสระโดยไม่ส่งผลกระทบต่อ Object อื่น

---

## ข้อ 5: Extra Credit

Implement Class Variables และ Class Methods โดยใช้ static สำหรับจัดเก็บข้อมูลร่วมกันระหว่างทุก Object

### 5.1 การจัดเก็บข้อมูล

ใช้ TreeMap สำหรับเก็บจำนวนเครื่องฟอกอากาศของแต่ละรุ่น โดยกำหนดให้

- Key คือชื่อรุ่นของเครื่องฟอกอากาศ
- Value คือจำนวนเครื่องฟอกอากาศของรุ่นนั้น

เมื่อมีการสร้าง Object ใหม่ Constructor จะทำหน้าที่ดังนี้

1. เพิ่มค่า totalCount ขึ้น 1
2. ตรวจสอบว่าชื่อรุ่นมีอยู่ใน modelCounts หรือไม่
3. หากเป็นรุ่นใหม่ ให้เพิ่มค่า modelCount ขึ้น 1
4. เพิ่มจำนวนเครื่องของรุ่นนั้นใน modelCounts ขึ้น 1

### 5.2 การหารุ่นที่มีจำนวนเครื่องมากที่สุด

Method mostPopularModel() ใช้ for-loop วนตรวจสอบจำนวนเครื่องของแต่ละรุ่น โดยเก็บจำนวนสูงสุดไว้ใน maxCount และชื่อรุ่นที่มีจำนวนสูงสุดไว้ใน result

หากหลายรุ่นมีจำนวนเครื่องเท่ากัน จะเลือกชื่อรุ่นแรกตามลำดับของ TreeMap

หากยังไม่มีข้อมูลเครื่องฟอกอากาศ จะคืนค่า null

### 5.3 การคำนวณจำนวนเครื่องเฉลี่ยต่อรุ่น

Method averageCountPerModel() คำนวณโดยนำจำนวนเครื่องทั้งหมดหารด้วยจำนวนรุ่นที่แตกต่างกัน

Average = totalCount / modelCount

ใช้ Casting เป็น double เพื่อให้ผลลัพธ์เป็นทศนิยม และตรวจสอบกรณีที่ modelCount เป็น 0 ก่อนทำการหาร

### 5.4 การทดสอบ Class Variables และ Class Methods

สร้าง Object เพิ่มเติมใน Lab02.java เพื่อทดสอบการนับจำนวนเครื่องและจำนวนรุ่น

| Object | Model | Serial Number |
|---|---|---|
| a | Pro | 001 |
| b | Standard | 002 |
| c | Pro | 003 |
| d | Standard | 004 |
| e | Pro | 005 |

### 5.5 Expected Results

| รายการ | ผลลัพธ์ที่คาดหวัง |
|---|---|
| totalCount | 5 |
| modelCount | 2 |
| จำนวนเครื่องรุ่น Pro | 3 |
| จำนวนเครื่องรุ่น Standard | 2 |
| mostPopularModel() | Pro |
| averageCountPerModel() | 2.5 |

### 5.6 Expected Output

    ----- Extra Credit -----
    Total Count: 5
    Model Count: 2
    Model Counts: {Pro=3, Standard=2}
    Most Popular: Pro
    Average: 2.5