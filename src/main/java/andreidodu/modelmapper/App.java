package andreidodu.modelmapper;

import org.modelmapper.ModelMapper;

public class App {


	public static void main(String[] args) {

		ModelMapper modelMapper = new ModelMapper();

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

		modelMapper.validate();

		Person db = new Person();
		Consensus consensus = new Consensus();
		consensus.setA(true);
		consensus.setB(false);
		consensus.setC(true);
		db.setConsensus(consensus);

		System.out.println(modelMapper.map(db, PersonDTO.class));

		PersonDTO dto = new PersonDTO();
		dto.setA(true);
		dto.setB(false);
		dto.setC(true);
		System.out.println(modelMapper.map(dto, Person.class));
	}
}
