package airPlan.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airPlan.model.CodeList;
import airPlan.model.Manual;

@Repository
public class JdbcCodeListRepository implements CodeListRepository{
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcCodeListRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public CodeList save(CodeList codeList) {
		jdbc.update(
				"insert into codelist (mnl_name, flg_secundary, cdl_section,"
				+ " cdl_sub_section, cdl_block, cdl_block_name, cdl_code) values (?,?,?,?,?,?,?)",
				codeList.getMnl_name(), codeList.getFlg_secundary(),
				codeList.getCdl_section(), codeList.getCdl_sub_section(),
				codeList.getCdl_block(), codeList.getCdl_block_name(),
				codeList.getCdl_code()
				);
		
		return codeList;
	}
	
	@Override
	public CodeList delete(CodeList codeList) {
		jdbc.update(
				"delete from codelist where mnl_name = (?) and flg_secundary = (?) and cdl_section = (?)",
				codeList.getMnl_name(), codeList.getFlg_secundary(),
				codeList.getCdl_section()
				);
		
		return codeList;
	}
	
	@Override
	public CodeList edit(CodeList codeList) {
		jdbc.update(
				"update codelist set mnl_name = (?), flg_secundary = (?), "
				+ "cdl_section = (?), cdl_sub_section = (?), "
				+ "cdl_block = (?), cdl_block_name = (?), "
				+ "cdl_code = (?) "
				+ "where mnl_name = (?) and flg_secundary = (?) "
				+ "and cdl_section = (?) and cdl_block = (?)",
				codeList.getMnl_name(), codeList.getFlg_secundary(),
				codeList.getCdl_section(), codeList.getCdl_sub_section(),
				codeList.getCdl_block(), codeList.getCdl_block_name(),
				codeList.getCdl_code(), codeList.getMnl_name(), codeList.getFlg_secundary(),
				codeList.getCdl_section(), codeList.getCdl_block());
		
		return codeList;
	}
	
}