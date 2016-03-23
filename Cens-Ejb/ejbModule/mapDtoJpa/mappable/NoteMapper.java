package mapDtoJpa.mappable;

import dto.NoteDTO;
import mapDtoJpa.mapper.Mapper;
import model.Note;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Arrays;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class NoteMapper extends Mapper<NoteDTO, Note> {

    @Inject
    private Provider<AssocEvaluerMapper> assocEvaluerMapper;

    @Override
    public NoteDTO mapFromEntity(Note note, String... instance) {
        if (note == null) {
            return null;
        }
        NoteDTO result = new NoteDTO();
        result.setNoteId(note.getNoteId());
        result.setNoteAbvr(note.getNoteAbvr());
        result.setNoteLibelle(note.getNoteLibelle());
        result.setNoteValeur(note.getNoteValeur());
        result.setNoteCouleur(note.getNoteCouleur());
        result.setNoteActive(note.getNoteActive());

        if (Arrays.binarySearch(instance, "AssocEvaluerMapper") < 0) {
            result.setAssocEvaluers1(assocEvaluerMapper.get().mapFromEntity(note.getAssocEvaluers1()));
            result.setAssocEvaluers2(assocEvaluerMapper.get().mapFromEntity(note.getAssocEvaluers2()));
        }
        return result;
    }

    @Override
    public Note mapToEntity(NoteDTO noteDTO, String... instance) {
        if (noteDTO == null) {
            return null;
        }
        Note result = new Note();
        result.setNoteId(noteDTO.getNoteId());
        result.setNoteAbvr(noteDTO.getNoteAbvr());
        result.setNoteLibelle(noteDTO.getNoteLibelle());
        result.setNoteValeur(noteDTO.getNoteValeur());
        result.setNoteCouleur(noteDTO.getNoteCouleur());
        result.setNoteActive(noteDTO.getNoteActive());

        if (Arrays.binarySearch(instance, "AssocEvaluerMapper") < 0) {
            result.setAssocEvaluers1(assocEvaluerMapper.get().mapToEntity(noteDTO.getAssocEvaluers1()));
            result.setAssocEvaluers2(assocEvaluerMapper.get().mapToEntity(noteDTO.getAssocEvaluers2()));
        }
        return result;
    }
}
