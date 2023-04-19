package andrei.modelmapper.mapper.common;

import org.modelmapper.ModelMapper;

public class ModelMapperSingleton {

	private static ModelMapper modelMapper;

	public static ModelMapper retrieveModelMapper() {
		if (modelMapper == null) {
			modelMapper = new ModelMapper();
		}
		return modelMapper;
	}

}
