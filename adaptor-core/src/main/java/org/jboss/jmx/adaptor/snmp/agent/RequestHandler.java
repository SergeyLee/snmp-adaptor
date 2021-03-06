/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.jmx.adaptor.snmp.agent;

import java.util.List;

import javax.management.MBeanServer;

import org.jboss.jmx.adaptor.snmp.config.attribute.ManagedBean;
import org.jboss.logging.Logger;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.Variable;

/**
 * Interface that must be implemented by classes
 * that provide agent get/set functionality
 * 
 * @author  <a href="mailto:dimitris@jboss.org">Dimitris Andreadis</a>
 * @version $Revision: 110455 $
 */
public interface RequestHandler extends SnmpAgentRequestHandler
{
   /**
    * Perform initialization, possibly by parsing
    * mapping information from resourceName
    * 
    * @param resourceName file containing mappinginfo
    * @param server the mbean server to forward mapped get/set requests 
    * @param logger the shared logger to use
    * @param uptime the snmp agent uptime
    * @throws Exception in case of initialization problem
    */
   void initialize(String resourceName, MBeanServer server, Logger loggger, Clock uptime)
      throws Exception;

   void addAttributeMappings(List<ManagedBean> mappings);
   void removeAttributeMappings(List<ManagedBean> mappings);
   Variable getValueFor(OID oid) throws NoSuchInstanceException, VariableTypeException;
} // RequestHandler
