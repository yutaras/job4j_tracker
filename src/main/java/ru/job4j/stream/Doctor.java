package ru.job4j.stream;

public class Doctor {

    private String name;
    private String surname;
    private byte age;
    private String speciality;
    private String qualification;
    private boolean experience;
    private String gender;

    static class Builder {
        private String name;
        private String surname;
        private byte age;
        private String speciality;
        private String qualification;
        private boolean experience;
        private String gender;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildSpeciality(String speciality) {
            this.speciality = speciality;
            return this;
        }

        Builder buildQualification(String qualification) {
            this.qualification = qualification;
            return this;
        }

        Builder buildExperience(boolean experience) {
            this.experience = experience;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Doctor build() {
            Doctor doctor = new Doctor();
            doctor.name = name;
            doctor.surname = surname;
            doctor.age = age;
            doctor.speciality = speciality;
            doctor.qualification = qualification;
            doctor.experience = experience;
            doctor.gender = gender;
            return doctor;
        }
    }

    public static void main(String[] args) {
        Doctor doctor = new Builder().buildName("Василий")
                .buildSurname("Орлов")
                .buildAge((byte) 32)
                .buildSpeciality("терапевт")
                .buildQualification("второй категории")
                .buildExperience(true)
                .buildGender("мужской")
                .build();
        System.out.println(doctor);
    }

    @Override
    public String toString() {
        return "Doctor{" + "name='" + name + '\'' + ", surname='" + surname + '\''
                + ", age=" + age + ", speciality='" + speciality + '\''
                + ", qualification='" + qualification + '\''
                + ", experience=" + experience + ", gender='" + gender + '\'' + '}';
    }
}
