# Lab 02: Building Classes

## ข้อ 1: การออกแบบ AirPurifier Class

คลาส AirPurifier ใช้จำลองเครื่องฟอกอากาศที่สามารถเปิด–ปิดเครื่อง ปรับความเร็วพัดลม และเก็บค่าฝุ่น PM2.5 ได้

### 1.1 Instance Variables

| ตัวแปร | Data Type | หน้าที่ |
|---|---|---|
| model | String | เก็บชื่อรุ่นของเครื่อง |
| serialNo | String | เก็บหมายเลขประจำเครื่อง |
| power | boolean | เก็บสถานะเปิด–ปิดเครื่อง |
| fanSpeed | int | เก็บระดับความเร็วพัดลม 0–3 |
| pm25 | double | เก็บค่าฝุ่น PM2.5 |

### 1.2 Instance Methods

| Method | หน้าที่ |
|---|---|
| turnOn() | เปิดเครื่อง |
| turnOff() | ปิดเครื่อง |
| setFanSpeed(int speed) | ปรับความเร็วพัดลม |
| setPM25(double value) | กำหนดค่าฝุ่น PM2.5 |
| isOn() | ตรวจสอบสถานะเปิด–ปิด |
| getFanSpeed() | คืนค่าความเร็วพัดลม |
| getPM25() | คืนค่าฝุ่น PM2.5 |
| showStatus() | แสดงข้อมูลทั้งหมดของเครื่อง |

### 1.3 Class Variables

| ตัวแปร | Data Type | หน้าที่ |
|---|---|---|
| totalCount | static int | เก็บจำนวนเครื่องทั้งหมด |
| modelCount | static int | เก็บจำนวนรุ่นที่แตกต่างกัน |
| modelCounts | static Map<String, Integer> | เก็บจำนวนเครื่องของแต่ละรุ่น |

### 1.4 Class Methods

| Method | หน้าที่ |
|---|---|
| getTotalCount() | คืนค่าจำนวนเครื่องทั้งหมด |
| getModelCount() | คืนค่าจำนวนรุ่นทั้งหมด |
| mostPopularModel() | หารุ่นที่มีจำนวนเครื่องมากที่สุด |
| averageCountPerModel() | หาจำนวนเครื่องเฉลี่ยต่อรุ่น |

## ข้อ 2: หลักการทำงานของแต่ละ Method

### 2.1 Constructor

AirPurifier(String model, String serialNo)

รับชื่อรุ่นและหมายเลขประจำเครื่องเข้ามา แล้วกำหนดค่าให้กับ Object โดยมีสถานะเริ่มต้นเป็นปิดเครื่อง ความเร็วพัดลมเป็น 0 และค่าฝุ่นเป็น 0.0

### 2.2 Instance Methods

| Method | Input | หลักการทำงาน | Return |
|---|---|---|---|
| turnOn() | ไม่มี | กำหนด power เป็น true และ fanSpeed เป็น 1 | void |
| turnOff() | ไม่มี | กำหนด power เป็น false และ fanSpeed เป็น 0 | void |
| setFanSpeed() | int speed | ถ้าเครื่องเปิดอยู่และ speed อยู่ระหว่าง 1–3 ให้เปลี่ยนค่า fanSpeed | void |
| setPM25() | double value | ถ้าค่าไม่ติดลบ ให้เปลี่ยนค่า pm25 | void |
| isOn() | ไม่มี | คืนค่า power | boolean |
| getFanSpeed() | ไม่มี | คืนค่า fanSpeed | int |
| getPM25() | ไม่มี | คืนค่า pm25 | double |
| showStatus() | ไม่มี | แสดงข้อมูลของเครื่องผ่าน Console | void |

### 2.3 Class Methods

| Method | Input | หลักการทำงาน | Return |
|---|---|---|---|
| getTotalCount() | ไม่มี | คืนค่าจำนวนเครื่องทั้งหมด | int |
| getModelCount() | ไม่มี | คืนค่าจำนวนรุ่นที่แตกต่างกัน | int |
| mostPopularModel() | ไม่มี | เปรียบเทียบจำนวนเครื่องของแต่ละรุ่น แล้วคืนชื่อรุ่นที่มีจำนวนมากที่สุด หรือ null หากไม่มีข้อมูล | String |
| averageCountPerModel() | ไม่มี | นำจำนวนเครื่องทั้งหมดหารด้วยจำนวนรุ่น หากไม่มีข้อมูลให้คืน 0.0 | double |