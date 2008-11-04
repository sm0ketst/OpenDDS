/*
 * $Id$
 */

package org.opendds.jms.management;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import DDS.DomainParticipantFactory;
import OpenDDS.DCPS.TheParticipantFactory;
import OpenDDS.DCPS.TheServiceParticipant;
import OpenDDS.DCPS.transport.TheTransportFactory;

import org.opendds.jms.management.annotation.Attribute;
import org.opendds.jms.management.annotation.Constructor;
import org.opendds.jms.management.annotation.Description;
import org.opendds.jms.management.annotation.KeyProperty;
import org.opendds.jms.management.annotation.Operation;

/**
 * @author  Steven Stallion
 * @version $Revision$
 */
@Description("OpenDDS DomainParticipantFactory MBean")
public class ParticipantFactoryService extends DynamicMBeanSupport implements ServiceMBean {
    private Log log;

    private String service;
    private boolean active;

    private DomainParticipantFactory instance;

    @Constructor
    public ParticipantFactoryService() {
        // DCPS Dynamic Attributes

        // ORB Dynamic Attributes
    }

    @KeyProperty
    public void setService(String service) {
        this.service = service;
    }

    @Attribute
    public boolean isActive() {
        return active;
    }

    @Attribute
    public DomainParticipantFactory getInstance() {
        return instance;
    }

    @Operation
    public void start() throws Exception {
        if (isActive()) {
            throw new IllegalStateException(service + " already started!");
        }

        verify();

        log = LogFactory.getLog(service);
        if (log.isInfoEnabled()) {
            log.info("Starting " + service);
        }

        instance = TheParticipantFactory.WithArgs(null); //TODO args
        if (instance == null) {
            throw new IllegalStateException("Unable to initialize DomainParticipantFactory; please check logs.");
        }

        active = true;
    }

    @Operation
    public void stop() throws Exception {
        if (!isActive()) {
            throw new IllegalStateException(service + " already stopped!");
        }

        if (log.isInfoEnabled()) {
            log.info("Stopping " + service);
        }

        TheTransportFactory.release();
        TheServiceParticipant.shutdown();

        instance = null;
        log = null;

        active = false;
    }
}
