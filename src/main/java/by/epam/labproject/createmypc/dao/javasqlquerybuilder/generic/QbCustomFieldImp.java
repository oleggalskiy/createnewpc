package by.epam.labproject.createmypc.dao.javasqlquerybuilder.generic;

import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbField;

/**
 * Immutable class to implement custom field.
 * @author DanFickle
 */
class QbCustomFieldImp implements QbField
{
	private final String m_custom;
	
	QbCustomFieldImp(String custom)
	{
		m_custom = custom;
	}

	@Override
	public String toString() 
	{
		return m_custom;
	}
}