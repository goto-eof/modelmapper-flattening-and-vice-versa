package andrei.modelmapper.mapper;

import org.modelmapper.ModelMapper;

import andrei.modelmapper.dto.PersonDTO;
import andrei.modelmapper.mapper.common.ModelMapperI;
import andrei.modelmapper.mapper.common.ModelMapperSingleton;
import andrei.modelmapper.model.Person;

public class PersonaMapper implements ModelMapperI<Person, PersonDTO> {

	private ModelMapper modelMapper;

	public PersonaMapper() {

		modelMapper = ModelMapperSingleton.retrieveModelMapper();

		modelMapper.typeMap(Person.class, PersonDTO.class).addMappings(mapper -> {
			mapper.<Boolean> map(src -> src.getConsensus().isA(), PersonDTO::setA);
			mapper.<Boolean> map(src -> src.getConsensus().isB(), PersonDTO::setB);
			mapper.<Boolean> map(src -> src.getConsensus().isC(), PersonDTO::setC);
		});

		modelMapper.typeMap(PersonDTO.class, Person.class).addMappings(mapper -> {
			mapper.<Boolean> map(src -> src.isA(), (db, value) -> db.getConsensus().setA(value));
			mapper.<Boolean> map(src -> src.isB(), (db, value) -> db.getConsensus().setB(value));
			mapper.<Boolean> map(src -> src.isC(), (db, value) -> db.getConsensus().setC(value));
		});

	}

	@Override
	public Person toDB(PersonDTO dto) {
		return this.modelMapper.map(dto, Person.class);
	}

	@Override
	public PersonDTO toDTO(Person db) {
		return this.modelMapper.map(db, PersonDTO.class);
	}

}
