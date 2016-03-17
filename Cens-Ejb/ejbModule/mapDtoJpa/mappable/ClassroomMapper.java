package mapDtoJpa.mappable;

import dto.ClassroomDTO;
import mapDtoJpa.mapper.Mapper;
import model.Classroom;

import javax.inject.Inject;

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
    private AssocEnseignerMapper assocEnseignerMapper;

    @Inject
    private AssocEtudierMapper assocEtudierMapper;


    @Override
    public ClassroomDTO mapFromEntity(Classroom classroom) {
        if (classroom == null) {
            return null;
        }
        ClassroomDTO result = new ClassroomDTO();
        result.setClassroomId(classroom.getClassroomId());
        result.setFiliere(filiereMapper.mapFromEntity(classroom.getFiliere()));
        result.setNiveau(niveauMapper.mapFromEntity(classroom.getNiveau()));
        result.setEmploye(employeMapper.mapFromEntity(classroom.getEmploye()));
        result.setClassroomLibelle(classroom.getClassroomLibelle());
        result.setAssocEnseigners(assocEnseignerMapper.mapFromEntity(classroom.getAssocEnseigners()));
        result.setAssocEtudiers(assocEtudierMapper.mapFromEntity(classroom.getAssocEtudiers()));
        return result;
    }

    @Override
    public Classroom mapToEntity(ClassroomDTO classroomDTO) {
        if (classroomDTO == null) {
            return null;
        }
        Classroom result = new Classroom();
        result.setClassroomId(classroomDTO.getClassroomId());
        result.setFiliere(filiereMapper.mapToEntity(classroomDTO.getFiliere()));
        result.setNiveau(niveauMapper.mapToEntity(classroomDTO.getNiveau()));
        result.setEmploye(employeMapper.mapToEntity(classroomDTO.getEmploye()));
        result.setClassroomLibelle(classroomDTO.getClassroomLibelle());
        result.setAssocEnseigners(assocEnseignerMapper.mapToEntity(classroomDTO.getAssocEnseigners()));
        result.setAssocEtudiers(assocEtudierMapper.mapToEntity(classroomDTO.getAssocEtudiers()));
        return result;
    }
}
