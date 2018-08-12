package ExamArrPerGee.app.factory;

import ExamArrPerGee.app.constants.Texts;
import ExamArrPerGee.app.contracts.SpecialityFactory;
import ExamArrPerGee.app.contracts.Specialty;
import ExamArrPerGee.app.models.specialties.Heal;
import ExamArrPerGee.app.models.specialties.Swiftness;
import ExamArrPerGee.app.models.specialties.Toughness;

public class SpecialityFactoryImpl implements SpecialityFactory {

    @Override
    public Specialty create(String speciality) throws ClassNotFoundException {
        switch (speciality) {
        case Texts.SPECIALTY_HEAL:
            return new Heal();
        case Texts.SPECIALTY_TOUGHNESS:
            return new Toughness();
        case Texts.SPECIALTY_SWIFTNESS:
            return new Swiftness();
        default:
            throw new ClassNotFoundException();
        }
    }
}
