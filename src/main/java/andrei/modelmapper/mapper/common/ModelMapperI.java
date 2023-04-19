package andrei.modelmapper.mapper.common;

public interface ModelMapperI<DB, DTO> {

	public DB toDB(DTO dto);

	public DTO toDTO(DB db);

}
