package com.trung.nghia.DAO.impl;

import java.util.List;

import com.trung.nghia.DAO.INewDAO;
import com.trung.nghia.mapper.CateMapper;
import com.trung.nghia.mapper.NewMapper;
import com.trung.nghia.model.Category;
import com.trung.nghia.model.NewModel;
import com.trung.nghia.paging.Pageble;
import org.apache.commons.lang3.StringUtils;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findbyCategory(long categoryid) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryid);
	}

	@Override
	public Long save(NewModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news(title,thumbnail,shortdese,content,");
		sql.append("categoryid,createddate,createdby)");
		sql.append(" VALUES(?,?,?,?,?,?,?)");

		return insert(sql.toString(), newModel.getTitle(), newModel.getThumbnail(), newModel.getShortdese(),
				newModel.getContent(), newModel.getCategoryid(), newModel.getCreatedDate(), newModel.getCreatedBy());
	}

	@Override
	public NewModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE  id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
			return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ? ,thumbnail = ?,");
		sql.append("shortdese = ?,content = ?,categoryid = ?,");
		sql.append("createddate = ?,modifieddate = ?,createdby= ? ,modifiedby = ?  WHERE id = ? ");

		updata(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortdese(),
				updateNew.getContent(), updateNew.getCategoryid(), updateNew.getCreatedDate(),
				updateNew.getModifiedDate(), updateNew.getCreatedBy(), updateNew.getModifIedby(), updateNew.getId());

	}

	@Override
	public void delete(long ids) {
		String sql = "DELETE  FROM news WHERE id = ? ";
		updata(sql, ids);

	}

	@Override
	public List<NewModel> findAll(Pageble pagebl) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if (pagebl.getSorter() != null && StringUtils.isNoneBlank(pagebl.getSorter().getSortName())&&
		StringUtils.isNoneBlank(pagebl.getSorter().getSortBy())) {
			sql.append(" ORDER BY "+pagebl.getSorter().getSortName()+" " +pagebl.getSorter().getSortBy()+"");

		}
		if (pagebl.Offset() != null && pagebl.Limit() != null) {
			sql.append(" LIMIT " + pagebl.Offset() + ", " +pagebl.Limit()+"");

		}
    return query(sql.toString(), new NewMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM news";
		return count(sql);
	}


}
