/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdapterPattern;

import DataContainers.BloodExtractionTaskDataContainer;
import DataContainers.MedicalTaskDataContainer;
import DataContainers.VacinationTaskDataContainer;
import DataContainers.XRayScanTaskDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import Tasks.BloodExtraction;
import Tasks.Itasks;
import Tasks.MedicalCheckUp;
import Tasks.Vacination;
import Tasks.XRayScan;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import volunteermanagement.Enums.BloodType;
import volunteermanagement.Enums.MedicalDiagnosis;
import volunteermanagement.Enums.MedicalFields;
import volunteermanagement.Enums.TaskSkills;
import volunteermanagement.Enums.TaskType;

/**
 *
 * @author abeer
 */
public class TaskParseFactory {
    public static Itasks ParseTaskToString(TaskType type,String[] data){
        switch(type){
            case TaskType.VAC:
                return HandleVaccineTaskParser(data);
            case TaskType.XRS:
                return HandleXRayScanTaskParser(data);
            case TaskType.BE:
                return HandleBloodExtraction(data);
            case TaskType.MCU:
                return HandleMedicalCheckUp(data);
            default:
                return null;
        }
    }
    private static Itasks HandleBloodExtraction(String[] data){
        Collection<String> skillsInString = new Collection<>(data[0].split("\\|"));
        Collection<TaskSkills> reqSkills = new Collection<>();
        Iiterator<String> dataIterator = skillsInString.createStandardIterator();
        while(dataIterator.hasNext()){
            TaskSkills skill = TaskSkills.valueOf(dataIterator.getNext());
            reqSkills.Add(skill);
        }
        int hours = parseInt(data[1]);
        
        Collection<String> medicalRecord = new Collection<>(data[2].split("\\|"));
        Collection<MedicalDiagnosis> mRecord = new Collection<>();
        Iiterator<String> recordIterator = medicalRecord.createStandardIterator();
        while(recordIterator.hasNext()){
            MedicalDiagnosis rec = MedicalDiagnosis.valueOf(recordIterator.getNext());
            mRecord.Add(rec);
        }
        MedicalFields speciality = MedicalFields.valueOf(data[3]);
        
        boolean isFasting = parseBoolean(data[4]);
        int vialsCount = parseInt(data[5]);
        BloodType bt = BloodType.valueOf(data[6]);
        
        BloodExtractionTaskDataContainer container = new BloodExtractionTaskDataContainer(reqSkills,hours,isFasting,vialsCount,bt,mRecord,speciality);
        return new BloodExtraction(container);
    }
    private static Itasks HandleVaccineTaskParser(String[] data) {
        Collection<String> skillsInString = new Collection<>(data[0].split("\\|"));
        Collection<TaskSkills> reqSkills = new Collection<>();
        Iiterator<String> dataIterator = skillsInString.createStandardIterator();
        while(dataIterator.hasNext()){
            TaskSkills skill = TaskSkills.valueOf(dataIterator.getNext());
            reqSkills.Add(skill);
        }
        int hours = parseInt(data[1]);
        String vaccNum = data[4];
        int obsTime = parseInt(data[5]);
        Collection<String> medicalRecord = new Collection<>(data[2].split("\\|"));
        Collection<MedicalDiagnosis> mRecord = new Collection<>();
        Iiterator<String> recordIterator = medicalRecord.createStandardIterator();
        while(recordIterator.hasNext()){
            MedicalDiagnosis rec = MedicalDiagnosis.valueOf(recordIterator.getNext());
            mRecord.Add(rec);
        }
        MedicalFields speciality = MedicalFields.valueOf(data[3]);
        VacinationTaskDataContainer container = new VacinationTaskDataContainer(reqSkills,hours,vaccNum,obsTime,mRecord,speciality);
        return new Vacination(container);
    }
    
    private static Itasks HandleXRayScanTaskParser(String[] data) {
        Collection<String> skillsInString = new Collection<>(data[0].split("\\|"));
        Collection<TaskSkills> reqSkills = new Collection<>();
        Iiterator<String> dataIterator = skillsInString.createStandardIterator();
        while(dataIterator.hasNext()){
            TaskSkills skill = TaskSkills.valueOf(dataIterator.getNext());
            reqSkills.Add(skill);
        }
        int hours = parseInt(data[1]);
        boolean isPregnant = parseBoolean(data[4]);
        String targetScan = data[5];
        Collection<String> medicalRecord = new Collection<>(data[2].split("\\|"));
        Collection<MedicalDiagnosis> mRecord = new Collection<>();
        Iiterator<String> recordIterator = medicalRecord.createStandardIterator();
        while(recordIterator.hasNext()){
            MedicalDiagnosis rec = MedicalDiagnosis.valueOf(recordIterator.getNext());
            mRecord.Add(rec);
        }
        MedicalFields speciality = MedicalFields.valueOf(data[3]);
        XRayScanTaskDataContainer container = new XRayScanTaskDataContainer(reqSkills,hours,isPregnant,targetScan,mRecord,speciality);
        return new XRayScan(container);
    }

    private static Itasks HandleMedicalCheckUp(String[] data) {
        Collection<String> skillsInString = new Collection<>(data[0].split("\\|"));
        Collection<TaskSkills> reqSkills = new Collection<>();
        Iiterator<String> dataIterator = skillsInString.createStandardIterator();
        while(dataIterator.hasNext()){
            TaskSkills skill = TaskSkills.valueOf(dataIterator.getNext());
            reqSkills.Add(skill);
        }
        int hours = parseInt(data[1]);
        
        Collection<String> medicalRecord = new Collection<>(data[2].split("\\|"));
        Collection<MedicalDiagnosis> mRecord = new Collection<>();
        Iiterator<String> recordIterator = medicalRecord.createStandardIterator();
        while(recordIterator.hasNext()){
            MedicalDiagnosis rec = MedicalDiagnosis.valueOf(recordIterator.getNext());
            mRecord.Add(rec);
        }
        MedicalFields speciality = MedicalFields.valueOf(data[3]);
        MedicalTaskDataContainer container = new MedicalTaskDataContainer(reqSkills,hours,mRecord,speciality);
        return new MedicalCheckUp(container);
    }
}
