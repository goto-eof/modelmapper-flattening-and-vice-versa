package andrei.modelmapper;

import andrei.modelmapper.dto.PersonDTO;
import andrei.modelmapper.mapper.PersonaMapper;
import andrei.modelmapper.model.Consensus;
import andrei.modelmapper.model.Person;

public class App {

	public static void main(String[] args) {

		PersonaMapper modelMapper = new PersonaMapper();

		Person db = prepareModel();
		System.out.println(modelMapper.toDTO(db));

		PersonDTO dto = prepareDTO();
		System.out.println(modelMapper.toDB(dto));

	}

	private static PersonDTO prepareDTO() {
		PersonDTO dto = new PersonDTO();
		dto.setA(true);
		dto.setB(false);
		dto.setC(true);
		return dto;
	}

	private static Person prepareModel() {
		Person db = new Person();
		Consensus consensus = new Consensus();
		consensus.setA(true);
		consensus.setB(false);
		consensus.setC(true);
		db.setConsensus(consensus);
		return db;
	}

}
