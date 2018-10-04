package by.epam.labproject.createmypc;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import by.epam.labproject.createmypc.dao.CpuDAO;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.dao.impl.CpuDAOImpl;
import by.epam.labproject.createmypc.domain.CPUBean;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void findByIdTest(){
        CpuDAO cpuDAO = new CpuDAOImpl();
        try {
            assertEquals(null,cpuDAO.findById(0L));
        } catch (DAOException e) {
            e.printStackTrace();
        };
    }

}
