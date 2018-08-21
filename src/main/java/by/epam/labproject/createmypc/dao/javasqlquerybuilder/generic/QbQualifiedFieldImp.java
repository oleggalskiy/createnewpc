package by.epam.labproject.createmypc.dao.javasqlquerybuilder.generic;

import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbField;

/**
 * Immutable class to implement qualified fields.
 * @author DanFickle
 */
class QbQualifiedFieldImp implements QbField
{
	private final String m_table;
	private final String m_field;
	
	QbQualifiedFieldImp(String table, String field) 
	{
		m_table = table;
		m_field = field;
	}
	
	@Override
	public String toString()
	{
		return QbCommonImp.protectTableName(m_table) + ".`" + m_field + '`';
	}
}