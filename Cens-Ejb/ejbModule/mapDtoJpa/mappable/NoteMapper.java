package mapDtoJpa.mappable;

import dto.NoteDTO;
import mapDtoJpa.mapper.Mapper;
import model.Note;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class NoteMapper extends Mapper<NoteDTO, Note> {

//    @Inject
//    AssocEvaluerMapper assocEvaluerMapper;

    @Override
    public NoteDTO mapFromEntity(Note note) {
        if (note == null) {
            return null;
        }
        NoteDTO result = new NoteDTO();
        result.setNoteId(note.getNoteId());
        result.setNoteAbvr(note.getNoteAbvr());
        result.setNoteLibelle(note.getNoteLibelle());
        result.setNoteValeur(note.getNoteValeur());
        result.setNoteCouleur(note.getNoteCouleur());
//        result.setAssocEvaluers1(assocEvaluerMapper.mapFromEntity(note.getAssocEvaluers1()));
//        result.setAssocEvaluers2(assocEvaluerMapper.mapFromEntity(note.getAssocEvaluers2()));
        return result;
    }

    @Override
    public Note mapToEntity(NoteDTO noteDTO) {
        if (noteDTO == null) {
            return null;
        }
        Note result = new Note();
        result.setNoteId(noteDTO.getNoteId());
        result.setNoteAbvr(noteDTO.getNoteAbvr());
        result.setNoteLibelle(noteDTO.getNoteLibelle());
        result.setNoteValeur(noteDTO.getNoteValeur());
        result.setNoteCouleur(noteDTO.getNoteCouleur());
//        result.setAssocEvaluers1(assocEvaluerMapper.mapToEntity(noteDTO.getAssocEvaluers1()));
//        result.setAssocEvaluers2(assocEvaluerMapper.mapToEntity(noteDTO.getAssocEvaluers2()));
        return result;
    }
}
