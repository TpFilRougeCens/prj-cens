package mapDtoJpa.mappable;

import dto.ClassroomDTO;
import mapDtoJpa.mapper.Mapper;
import model.Classroom;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Arrays;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class ClassroomMapper extends Mapper<ClassroomDTO, Classroom> {

    @Inject
    private FiliereMapper filiereMapper;

    @Inject
    private NiveauMapper niveauMapper;

    @Inject
    private EmployeMapper employeMapper;

    @Inject
    private Provider<AssocEnseignerMapper> assocEnseignerMapper;

    @Inject
    private Provider<AssocEtudierMapper> assocEtudierMapper;


    @Override
    public ClassroomDTO mapFromEntity(Classroom classroom, String... instance) {
        if (classroom == null) {
            return null;
        }
        ClassroomDTO result = new ClassroomDTO();
        result.setClassroomId(classroom.getClassroomId());
        result.setFiliere(filiereMapper.mapFromEntity(classroom.getFiliere()));
        result.setNiveau(niveauMapper.mapFromEntity(classroom.getNiveau()));
        result.setEmploye(employeMapper.mapFromEntity(classroom.getEmploye()));
        result.setClassroomLibelle(classroom.getClassroomLibelle());
        if (Arrays.binarySearch(instance, "AssocEnseignerMapper") < 0) {
            result.setAssocEnseigners(assocEnseignerMapper.get().mapFromEntity(classroom.getAssocEnseigners()));
        }
        if (Arrays.binarySearch(instance, "AssocEtudierMapper") < 0) {
            result.setAssocEtudiers(assocEtudierMapper.get().mapFromEntity(classroom.getAssocEtudiers()));
        }
        return result;
    }

    @Override
    public Classroom mapToEntity(ClassroomDTO classroomDTO, String... instance) {
        if (classroomDTO == null) {
            return null;
        }
        Classroom result = new Classroom();
        result.setClassroomId(classroomDTO.getClassroomId());
        result.setFiliere(filiereMapper.mapToEntity(classroomDTO.getFiliere()));
        result.setNiveau(niveauMapper.mapToEntity(classroomDTO.getNiveau()));
        result.setEmploye(employeMapper.mapToEntity(classroomDTO.getEmploye()));
        result.setClassroomLibelle(classroomDTO.getClassroomLibelle());
        if (Arrays.binarySearch(instance, "AssocEnseignerMapper") < 0) {
            result.setAssocEnseigners(assocEnseignerMapper.get().mapToEntity(classroomDTO.getAssocEnseigners()));
        }
        if (Arrays.binarySearch(instance, "AssocEtudierMapper") < 0) {
            result.setAssocEtudiers(assocEtudierMapper.get().mapToEntity(classroomDTO.getAssocEtudiers()));
        }
        return result;
    }
}
