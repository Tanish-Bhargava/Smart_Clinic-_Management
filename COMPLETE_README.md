# Smart Clinic Management System - Complete Project Guide

## 📋 Project Overview

**Smart Clinic Management System** is a comprehensive full-stack web application designed to streamline clinic operations. It integrates **Java Core**, **SQL/MySQL**, **HTML**, **CSS**, **Bootstrap**, and **JavaScript** to create a complete healthcare management solution.

**Version:** 1.0  
**Last Updated:** February 2026

---

## 🎯 Key Features

### 1. Patient Management
- Register new patients
- View patient profiles and medical history
- Update patient information
- Track patient status (Active/Inactive/Discharged)
- Emergency contact information

### 2. Doctor Management
- Add and manage doctor profiles
- Track specialization and qualifications
- Monitor availability status
- Manage consultation fees
- Department assignments

### 3. Appointment System
- Schedule appointments
- Automatic availability checking
- Multiple consultation types (Online/Offline/Phone)
- Appointment status tracking
- Appointment cancellation

### 4. Medical Records
- Electronic medical records (EMR)
- Diagnosis tracking
- Treatment plans
- Vital signs recording
- Test results management

### 5. Prescription Management
- Digital prescriptions
- Medicine tracking
- Dosage and frequency management
- Drug interaction warnings

### 6. Billing System
- Invoice generation
- Multiple payment methods
- Payment status tracking
- Billing reports
- Receipt generation

### 7. Staff Management
- Employee records
- Payroll information
- Department assignments
- Attendance tracking

---

## 🏗️ Project Architecture

```
Smart_Clinic_Management/
├── src/
│   ├── models/
│   │   ├── Patient.java
│   │   ├── Doctor.java
│   │   ├── Appointment.java
│   │   ├── Prescription.java
│   │   ├── MedicalRecord.java
│   │   ├── Staff.java
│   │   ├── Billing.java
│   │   └── Department.java
│   │
│   ├── dao/
│   │   ├── DatabaseConnection.java
│   │   ├── PatientDAO.java
│   │   ├── DoctorDAO.java
│   │   ├── AppointmentDAO.java
│   │   ├── PrescriptionDAO.java
│   │   ├── MedicalRecordDAO.java
│   │   ├── StaffDAO.java
│   │   ├── BillingDAO.java
│   │   └── DepartmentDAO.java
│   │
│   ├── controllers/
│   │   ├── PatientController.java
│   │   ├── DoctorController.java
│   │   ├── AppointmentController.java
│   │   ├── BillingController.java
│   │   └── AdminController.java
│   │
│   ├── services/
│   │   ├── PatientService.java
│   │   ├── DoctorService.java
│   │   ├── AppointmentService.java
│   │   └── ReportService.java
│   │
│   └── Main.java
│
├── web/
│   ├── html/
│   │   ├── index.html
│   │   ├── patients.html
│   │   ├── doctors.html
│   │   ├── appointments.html
│   │   ├── billing.html
│   │   ├── medical-records.html
│   │   ├── prescriptions.html
│   │   ├── staff.html
│   │   └── admin.html
│   │
│   ├── css/
│   │   ├── style.css
│   │   ├── patients.css
│   │   ├── doctors.css
│   │   ├── appointments.css
│   │   ├── responsive.css
│   │   └── animations.css
│   │
│   └── js/
│       ├── script.js
│       ├── patients.js
│       ├── doctors.js
│       ├── appointments.js
│       ├── billing.js
│       ├── validation.js
│       ├── api.js
│       └── utils.js
│
├── database/
│   ├── clinic_database.sql
│   ├── sample_data.sql
│   ├── stored_procedures.sql
│   └── ER_Diagram.png
│
├── lib/
│   └── mysql-connector-java-8.0.33.jar
│
├── config/
│   └── database.properties
│
└── README.md
```

---

## 🛠️ Tech Stack

| Layer | Technologies |
|-------|--------------|
| **Frontend** | HTML5, CSS3, Bootstrap 5, JavaScript (ES6+) |
| **Backend** | Java Core (JDBC) |
| **Database** | MySQL 8.0+ |
| **IDE** | Eclipse IDE / IntelliJ IDEA / VS Code |
| **Server** | Apache Tomcat 9+ |
| **Build Tool** | Maven / Gradle |

---

## 📦 Installation & Setup

### Prerequisites
- Java Development Kit (JDK) 11+
- MySQL Server 8.0+
- IDE (Eclipse/IntelliJ/VS Code)
- Git

### Step 1: Clone Repository
```bash
git clone https://github.com/Tanish-Bhargava/Smart_Clinic-_Management.git
cd Smart_Clinic-_Management
```

### Step 2: Setup Database

1. Open MySQL Command Line / Workbench
2. Create database:
```sql
CREATE DATABASE smart_clinic;
USE smart_clinic;
```

3. Import database schema:
```bash
mysql -u root -p smart_clinic < database/clinic_database.sql
```

4. Verify tables:
```sql
SHOW TABLES;
```

### Step 3: Configure Database Connection

Edit `src/dao/DatabaseConnection.java`:
```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/smart_clinic";
private static final String DB_USER = "root";
private static final String DB_PASSWORD = "your_password"; // Add your MySQL password
```

### Step 4: Add MySQL Connector JAR

1. Copy `mysql-connector-java-8.0.33.jar` to project lib folder
2. Add JAR to classpath in IDE

### Step 5: Run Application

**For Java Swing Desktop Application:**
```bash
javac -cp .:lib/* src/models/*.java src/dao/*.java src/controllers/*.java src/Main.java
java -cp .:lib/* src.Main
```

**For Web Application (Tomcat):**
1. Create WAR file using Maven
2. Deploy to Tomcat webapps folder
3. Access at `http://localhost:8080/SmartClinic`

---

## 📋 Database Schema

### Core Tables

#### 1. **Patient Table**
```sql
- patient_id (PK)
- first_name
- last_name
- date_of_birth
- gender
- phone_no
- email
- blood_group
- medical_history
- allergies
- status
```

#### 2. **Doctor Table**
```sql
- doctor_id (PK)
- first_name
- last_name
- email
- phone_no
- department_id (FK)
- specialization
- qualification
- experience_years
- availability_status
- consultation_fee
- license_no
```

#### 3. **Appointment Table**
```sql
- appointment_id (PK)
- patient_id (FK)
- doctor_id (FK)
- appointment_date
- appointment_time
- status
- reason_for_visit
- consultation_type
```

#### 4. **Medical Record Table**
```sql
- record_id (PK)
- patient_id (FK)
- doctor_id (FK)
- diagnosis
- symptoms
- treatment_plan
- vital_signs
- blood_pressure
- heart_rate
- temperature
- weight
```

#### 5. **Prescription Table**
```sql
- prescription_id (PK)
- appointment_id (FK)
- patient_id (FK)
- medicine_name
- dosage
- frequency
- duration_days
- instructions
```

#### 6. **Billing Table**
```sql
- billing_id (PK)
- patient_id (FK)
- appointment_id (FK)
- amount
- payment_method
- payment_status
- invoice_number
- due_date
```

#### 7. **Staff Table**
```sql
- staff_id (PK)
- first_name
- last_name
- email
- phone_no
- department_id (FK)
- position
- salary
- date_of_joining
```

#### 8. **Department Table**
```sql
- dept_id (PK)
- dept_name
- dept_head
- contact_no
```

---

## 🔐 User Roles & Permissions

### 1. **Admin**
- Full access to all modules
- Manage doctors and staff
- View reports and analytics
- System configuration

### 2. **Doctor**
- View assigned patients
- Add/update medical records
- Create prescriptions
- View appointments
- Update prescription status

### 3. **Reception Staff**
- Register new patients
- Schedule appointments
- Update patient records
- Generate bills

### 4. **Patient** (Future Enhancement)
- View own medical records
- Book appointments
- View prescriptions
- Check billing history

---

## 💾 Core Java Classes Documentation

### Model Classes (POJO)

#### Patient.java
```java
Attributes:
- patientId (int)
- firstName (String)
- lastName (String)
- dateOfBirth (Date)
- gender (String)
- phoneNo (String)
- email (String)
- address (String)
- city (String)
- bloodGroup (String)
- allergies (String)
- medicalHistory (String)
- status (String)
```

#### Doctor.java
```java
Attributes:
- doctorId (int)
- firstName (String)
- lastName (String)
- email (String)
- phoneNo (String)
- departmentId (int)
- specialization (String)
- qualification (String)
- experienceYears (int)
- availabilityStatus (String)
- consultationFee (double)
- licenseNo (String)
```

#### Appointment.java
```java
Attributes:
- appointmentId (int)
- patientId (int)
- doctorId (int)
- appointmentDate (Date)
- appointmentTime (Time)
- status (String)
- reasonForVisit (String)
- consultationType (String)
- notes (String)
```

### DAO Classes

#### DatabaseConnection.java
```java
Methods:
- getConnection() : Connection
- closeConnection(Connection)
- testConnection() : void
```

#### PatientDAO.java
```java
Methods:
- addPatient(Patient) : boolean
- getPatient(int) : Patient
- getAllPatients() : List<Patient>
- updatePatient(Patient) : boolean
- deletePatient(int) : boolean
- searchPatient(String) : List<Patient>
```

#### DoctorDAO.java
```java
Methods:
- addDoctor(Doctor) : boolean
- getDoctor(int) : Doctor
- getAllDoctors() : List<Doctor>
- getDoctorsByDepartment(int) : List<Doctor>
- updateDoctorAvailability(int, String) : boolean
```

#### AppointmentDAO.java
```java
Methods:
- bookAppointment(Appointment) : boolean
- getAppointment(int) : Appointment
- getAllAppointments() : List<Appointment>
- getAppointmentsByPatient(int) : List<Appointment>
- getAppointmentsByDoctor(int) : List<Appointment>
- cancelAppointment(int) : boolean
- getDoctorAvailability(int, Date) : List<Time>
```

---

## 🌐 Frontend Components

### HTML Pages

#### index.html
- Home page with dashboard overview
- Quick statistics
- Navigation menu
- Feature highlights

#### patients.html
- Patient list table
- Search and filter functionality
- Add new patient form
- Edit/delete patient options
- Patient details view

#### doctors.html
- Doctor list
- Filter by department/specialization
- Doctor profile information
- Availability status

#### appointments.html
- Appointment booking form
- Appointment list
- Appointment status tracking
- Reschedule/cancel options

#### billing.html
- Invoice list
- Generate new invoice
- Payment tracking
- Reports

### CSS Styling
- Responsive design
- Bootstrap 5 integration
- Custom animations
- Print-friendly styles

### JavaScript Functions

#### CRUD Operations
```javascript
- fetchPatients()
- savePatient()
- editPatient(id)
- deletePatient(id)
- displayPatients(data)
```

#### Form Validation
```javascript
- validateEmail(email)
- validatePhone(phone)
- validateForm(formData)
- showNotification(message, type)
```

#### API Communication
```javascript
- fetchData(url, method, data)
- postRequest(url, data)
- putRequest(url, data)
- deleteRequest(url)
```

---

## 🔗 API Endpoints (Backend Integration)

### Patient Endpoints
```
GET    /api/patients              - Get all patients
GET    /api/patients/{id}         - Get patient by ID
POST   /api/patients              - Create new patient
PUT    /api/patients/{id}         - Update patient
DELETE /api/patients/{id}         - Delete patient
GET    /api/patients/search       - Search patients
```

### Doctor Endpoints
```
GET    /api/doctors               - Get all doctors
GET    /api/doctors/{id}          - Get doctor by ID
POST   /api/doctors               - Create doctor
PUT    /api/doctors/{id}          - Update doctor
DELETE /api/doctors/{id}          - Delete doctor
GET    /api/doctors/dept/{deptId} - Get doctors by department
```

### Appointment Endpoints
```
GET    /api/appointments          - Get all appointments
GET    /api/appointments/{id}     - Get appointment by ID
POST   /api/appointments          - Book appointment
PUT    /api/appointments/{id}     - Update appointment
DELETE /api/appointments/{id}     - Cancel appointment
GET    /api/appointments/patient/{patientId} - Patient appointments
GET    /api/appointments/doctor/{doctorId}   - Doctor appointments
```

---

## 📊 Sample Queries

### Get All Active Patients
```sql
SELECT * FROM patient WHERE status = 'active';
```

### Get Doctor's Appointments
```sql
SELECT a.*, p.first_name, p.last_name, p.phone_no
FROM appointment a
JOIN patient p ON a.patient_id = p.patient_id
WHERE a.doctor_id = 1 AND a.appointment_date = CURDATE();
```

### Get Patient Medical History
```sql
SELECT a.appointment_date, d.first_name, d.last_name, m.diagnosis
FROM appointment a
JOIN doctor d ON a.doctor_id = d.doctor_id
LEFT JOIN medical_record m ON a.appointment_id = m.appointment_id
WHERE a.patient_id = 1
ORDER BY a.appointment_date DESC;
```

### Get Pending Bills
```sql
SELECT * FROM billing
WHERE payment_status IN ('pending', 'partial')
ORDER BY due_date;
```

---

## 🐛 Troubleshooting

### Database Connection Error
**Issue:** "Connection refused"  
**Solution:** 
- Verify MySQL service is running
- Check database credentials in DatabaseConnection.java
- Ensure MySQL driver JAR is in classpath

### ClassNotFoundException
**Issue:** "Class not found: com.mysql.cj.jdbc.Driver"  
**Solution:**
- Add mysql-connector-java JAR to lib folder
- Add JAR to project classpath/build path

### Port Already in Use
**Issue:** "Port 3306/8080 already in use"  
**Solution:**
- Change port in connection string or Tomcat config
- Kill process using the port

---

## 📈 Future Enhancements

- [ ] Patient portal for self-service
- [ ] SMS/Email notifications
- [ ] Advanced reporting and analytics
- [ ] Mobile app (Android/iOS)
- [ ] Prescription refill system
- [ ] Lab integration
- [ ] Insurance claims management
- [ ] Video consultation support
- [ ] Inventory management for pharmacy
- [ ] AI-based appointment recommendations

---

## 📝 License

This project is licensed under MIT License.

---

## 👥 Contributors

- **Tanish Bhargava** - Project Lead & Full Stack Developer
- GitHub: [Tanish-Bhargava](https://github.com/Tanish-Bhargava)

---

## 📧 Support

For issues, questions, or suggestions:
- GitHub Issues: [Project Issues](https://github.com/Tanish-Bhargava/Smart_Clinic-_Management/issues)
- Email: tanish.bhargava@example.com

---

## 🎓 Learning Resources

- [Java JDBC Tutorial](https://www.javatpoint.com/jdbc)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Bootstrap Documentation](https://getbootstrap.com/docs/)
- [JavaScript MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript)

---

**Last Updated:** February 2026  
**Version:** 1.0.0  
Happy Coding! 🚀