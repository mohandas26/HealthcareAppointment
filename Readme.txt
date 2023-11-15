Project Summary:

The Healthcare Appointment Application is a Spring Boot-based system that simplifies doctor-patient appointment management. It provides RESTful API endpoints for booking ,updating,deleting and retrieving appointments and also for retrieving patient profiles.

The application is built on a solid foundation, utilizing Spring Boot and H2 for data storage, and it follows best practices for clean code, separation of concerns, and secure user data handling.


1. Entities:

    - Doctor Entity:
        - `doctorId`: Unique identifier for each doctor.
        - `doctorName`: Name of the doctor.
        - `specialization`: Specialization of the doctor (e.g., "Cardiology," "Dermatology").
        - `appointments`: A list of `Appointment` entities representing the appointments associated with the doctor.

    - Patient Entity:
        - `patientId`: Unique identifier for each patient.
        - `patientFirstName`: First name of the patient.
        - `patientLastName`: Last name of the patient.
        - `patientEmail`: Email address of the patient (unique).
        - `appointment`: A reference to the `Appointment` entity representing the patient's appointment.

    - Appointment Entity:
        - `id`: Unique identifier for each appointment
        - `time`: Date and time of the appointment
        - `doctor`: A reference to the associated doctor for the appointment.
        - `patient`: A reference to the associated patient for the appointment.


2. Repositories:

    - AppointmentRepository:
        - Extends `JpaRepository` for the `Appointment` entity. It allows for data access operations related to appointments.

    - DoctorRepository:
        - Extends `JpaRepository` for the `Doctor` entity. It enables data access related to doctors.

    - PatientRepository:
        - Extends `JpaRepository` for the `Patient` entity, allowing data access operations related to patients.


3.Database Design

The application uses a H2 database to store data, including doctor and patient information,and appointments. Key attributes and tables include:

 Doctor Table

| Column Name | Data Type    | Description                 |
| ----------- | ------------ | --------------------------- |
| doctorId    | BIGINT          | Unique identifier for doctors |
| doctorName  | VARCHAR(255) | Name of the doctor          |
| specialization | VARCHAR(255) | Doctor's specialization   |


 Patient Table

| Column Name      | Data Type    | Description               |
| --------------- | ------------ | ------------------------- |
| patientId       | BIGINT          | Unique identifier for patients |
| patientFirstName | VARCHAR(255) | First name of the patient |
| patientLastName  | VARCHAR(255) | Last name of the patient  |
| patientContact   | VARCHAR(255)  | Contact information for the patient |

 Appointment Table

| Column Name | Data Type    | Description                 |
| ----------- | ------------ | --------------------------- |
| id | BIGINT        | Unique identifier for appointments |
| time        | VARCHAR(255     | Date and time of the appointment |
| doctor_doc_id | BIGINT        | Foreign key referencing the doctor |
| patient_patient_id | BIGINT        | Foreign key referencing the patient |

4. RestController
The application provides RESTful API endpoints for various functionalities:

        1. POST http://localhost:8080/api/appointments - Book a new appointment between patient and doctor.
        2. GET http://localhost:8080/api/appointments - Retrieve all appointments for a user.
        3. PUT  http://localhost:8080/api/appointments/{appointmentId} - Reschedule an existing appointment.
        4. DELETE http://localhost:8080/api/{appointmentId} - Cancel an appointment.
        5. GET http://localhost:8080/api/patients/{patientId} - Access a patient's records using id.

Already some data will be inserted into H2 after application started.
Sample Response body for POST and PUT Mapping:

{
    "id" : 1,
    "time" : "2018-04-26 10:30",
    "doctor": {
        "doctorId": 1
    },
    "patient": {
        "patientId":2
   }
}