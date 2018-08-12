package ExamArrPerGee.app.contracts;

public interface SpecialityFactory {

    Specialty create(String speciality) throws ClassNotFoundException;
}
