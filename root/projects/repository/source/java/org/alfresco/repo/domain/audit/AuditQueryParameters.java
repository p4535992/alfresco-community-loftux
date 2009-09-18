/*
 * Copyright (C) 2005-2009 Alfresco Software Limited.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.

 * As a special exception to the terms and conditions of version 2.0 of 
 * the GPL, you may redistribute this Program in connection with Free/Libre 
 * and Open Source Software ("FLOSS") applications as described in Alfresco's 
 * FLOSS exception.  You should have recieved a copy of the text describing 
 * the FLOSS exception, and it is also available here: 
 * http://www.alfresco.com/legal/licensing"
 */
package org.alfresco.repo.domain.audit;

import java.util.Date;

/**
 * Query parameters for <b>alf_audit_entry</b> table.
 * 
 * @author Derek Hulley
 * @since 3.2
 */
public class AuditQueryParameters
{
    private Long auditEntryId;
    private Long auditAppNameId;
    private Long auditUserId;
    private Long auditFromTime;
    private Long auditToTime;
    private Long searchKeyId;
    private Long searchValueId;
    
    public AuditQueryParameters()
    {
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(512);
        sb.append("AuditEntryParameters")
          .append("[ auditEntryId=").append(auditEntryId)
          .append(", auditAppNameId=").append(auditAppNameId)
          .append(", auditUserId=").append(auditUserId)
          .append(", auditFromTime").append(auditFromTime == null ? null : new Date(auditFromTime))
          .append(", auditToTime").append(auditToTime == null ? null : new Date(auditToTime))
          .append(", searchKeyId").append(searchKeyId)
          .append(", searchValueId").append(searchValueId)
          .append("]");
        return sb.toString();
    }

    public Long getAuditEntryId()
    {
        return auditEntryId;
    }

    public void setAuditEntryId(Long entryId)
    {
        this.auditEntryId = entryId;
    }

    public Long getAuditAppNameId()
    {
        return auditAppNameId;
    }

    public void setAuditAppNameId(Long auditAppNameId)
    {
        this.auditAppNameId = auditAppNameId;
    }

    public Long getAuditUserId()
    {
        return auditUserId;
    }

    public void setAuditUserId(Long auditUserId)
    {
        this.auditUserId = auditUserId;
    }

    public Long getAuditFromTime()
    {
        return auditFromTime;
    }

    public void setAuditFromTime(Long from)
    {
        this.auditFromTime = from;
    }

    public Long getAuditToTime()
    {
        return auditToTime;
    }

    public void setAuditToTime(Long to)
    {
        this.auditToTime = to;
    }

    public Long getSearchKeyId()
    {
        return searchKeyId;
    }

    public void setSearchKeyId(Long searchKeyId)
    {
        this.searchKeyId = searchKeyId;
    }

    public Long getSearchValueId()
    {
        return searchValueId;
    }

    public void setSearchValueId(Long searchValueId)
    {
        this.searchValueId = searchValueId;
    }
}
