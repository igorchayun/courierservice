package testtask.courierservice.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import testtask.courierservice.domain.Task;
import java.util.List;

@Repository
@Mapper
public interface TaskMapper {

    @Select("SELECT * FROM TASK")
    List<Task> findAll();

    @Select("SELECT * FROM TASK WHERE orderNumber = #{orderNumber}")
    List<Task> findByOrderNumber(@Param("orderNumber") String orderNumber);

    @Select("SELECT * FROM TASK WHERE orderNumber LIKE #{filter}")
    List<Task> findByFilter(@Param("filter") String filter);

    @Insert("INSERT INTO TASK (orderNumber, creationDate) values(#{orderNumber}, #{creationDate})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Long.class)
    void createTask(Task task);

}
