package by.epam.labproject.createmypc.dao.javasqlquerybuilder.generic;

import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbField;

/**
 * Immutable class to implement a standard un-qualified field.
 * @author DanFickle
 */
class QbStdFieldImp implements QbField
{
	private final String m_fieldName;

	QbStdFieldImp(String field)
	{
		m_fieldName = field;
	}
	
	@Override
	public String toString() 
	{
		return '`' + m_fieldName + '`';
	}
}