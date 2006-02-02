/*
 * Copyright (C) 2005 Alfresco, Inc.
 *
 * Licensed under the Mozilla Public License version 1.1 
 * with a permitted attribution clause. You may obtain a
 * copy of the License at
 *
 *   http://www.alfresco.org/legal/license.txt
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */
package org.alfresco.webservice.sample;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.alfresco.webservice.repository.QueryResult;
import org.alfresco.webservice.repository.RepositoryFault;
import org.alfresco.webservice.repository.RepositoryServiceSoapBindingStub;
import org.alfresco.webservice.types.NamedValue;
import org.alfresco.webservice.types.Query;
import org.alfresco.webservice.types.QueryLanguageEnum;
import org.alfresco.webservice.types.Reference;
import org.alfresco.webservice.types.ResultSet;
import org.alfresco.webservice.types.ResultSetRow;
import org.alfresco.webservice.util.AuthenticationUtils;
import org.alfresco.webservice.util.WebServiceFactory;

/**
 * Web service sample 2
 * <p>
 * This sample shows how to execute a search using the repository web service and how to 
 * query for a nodes parents.
 * 
 * @author Roy Wetherall
 */
public class WebServiceSample2 implements WebServiceSampleConfig
{
    /**
     * Main function
     */
    public static void main(String[] args) 
        throws Exception
    {
        // Start the session
        AuthenticationUtils.startSession(USERNAME, PASSWORD);
        
        try
        {        
            // Execute the search sample
            executeSearch();        
        }
        finally
        {
            // End the session
            AuthenticationUtils.endSession();
        }
    }

    /**
     * Executes a sample query and provides an example of using a parent query.
     * 
     * @return                      returns a reference to a folder that is the parent of the search results
     *                              ( used in further samples)
     * @throws ServiceException     Service exception
     * @throws RemoteException      Remove exception
     * @throws RepositoryFault      Repository fault
     */
    public static Reference executeSearch() throws ServiceException, RemoteException, RepositoryFault
    {
        Reference parentReference = null;
        
        // Get a reference to the respository web service
        RepositoryServiceSoapBindingStub repositoryService = WebServiceFactory.getRepositoryService();         
        
        // Create a query object, looking for all items with alfresco in the name of text
        Query query = new Query(QueryLanguageEnum.lucene, "( +@\\{http\\://www.alfresco.org/1.0\\}name:alfresco*) OR  TEXT:alfresco*");
        
        // Execute the query
        QueryResult queryResult = repositoryService.query(STORE, query, false);
        
        // Display the results
        ResultSet resultSet = queryResult.getResultSet();
        ResultSetRow[] rows = resultSet.getRows();
        if (rows == null)
        {
            System.out.println("No query results found.");
        }
        else
        {
            System.out.println("Results from query:");
            outputResultSet(rows);
            
            // Get the id of the first result
            String firstResultId = rows[0].getNode().getId();
            Reference reference = new Reference(STORE, firstResultId, null);
            
            // Get the parent(s) of the first result
            QueryResult parentQueryResult = repositoryService.queryParents(reference);
            
            // Get the parent of the first result
            ResultSet parentResultSet = parentQueryResult.getResultSet();
            ResultSetRow[] parentRows = parentResultSet.getRows();
            if (parentRows == null)
            {
                System.out.println("No query results found.");
            }
            else
            {
                System.out.println("Results from parent query:");
                outputResultSet(parentRows);
                
                // Return the first parent (we can use in other samples)
                String firstParentId = parentRows[0].getNode().getId();
                parentReference = new Reference(STORE, firstParentId, null);
            }
        }
        
        return parentReference;    
    }

    /**
     * Helper method to output the rows contained within a result set
     * 
     * @param rows  an array of rows
     */
    public static void outputResultSet(ResultSetRow[] rows)
    {
        if (rows != null)
        {
            for (int x = 0; x < rows.length; x++)
            {
                ResultSetRow row = rows[x];
                
                NamedValue[] columns = row.getColumns();
                for (int y = 0; y < columns.length; y++)
                {
                    System.out.println("row " + x + ": "
                            + row.getColumns(y).getName() + " = "
                            + row.getColumns(y).getValue());
                }
            }
        }
    }

}
