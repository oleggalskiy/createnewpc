package by.epam.labproject.createmypc.dao.exception;

public class DAOException extends Exception{
    public DAOException() {
        super();
    }

    public DAOException(String msg) {
        super(msg);
    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(String msg, Exception e) {
        super(msg, e);
    }
}
