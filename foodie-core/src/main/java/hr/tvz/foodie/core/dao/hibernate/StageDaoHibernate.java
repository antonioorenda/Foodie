package hr.tvz.foodie.core.dao.hibernate;

import hr.tvz.foodie.core.dao.StageDao;
import hr.tvz.foodie.core.model.Stage;
import org.springframework.stereotype.Repository;

@Repository
public class StageDaoHibernate extends BaseDaoHibernate<Stage, Long> implements StageDao {}
