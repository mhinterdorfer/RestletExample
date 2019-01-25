package service;
/**
 * Copyright 2005-2014 Restlet
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or or EPL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://restlet.com/products/restlet-framework
 * 
 * Restlet is a registered trademark of Restlet S.A.S.
 */

import java.util.List;

import org.restlet.data.MediaType;
import org.restlet.data.Preference;
import org.restlet.data.Reference;
import org.restlet.ext.odata.Query;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import womomodel.Fahrzeug_in_saison;
import womomodel.Fahrzeug;
import womomodel.Kunde;
import womomodel.Mietfahrzeug;
import womomodel.Saison;
import womomodel.Standort;

/**
* Generated by the generator tool for the OData extension for the Restlet framework.<br>
*
* @see <a href="http://localhost:50021/WoMoService.svc/$metadata">Metadata of the target OData service</a>
*
*/
public class WoMoService extends org.restlet.ext.odata.Service {

    /**
     * Constructor.
     * 
     */
    public WoMoService() {
        super("http://localhost:50021/WoMoService.svc/");
    }

    /**
     * Adds a new entity to the service.
     * 
     * @param entity
     *            The entity to add to the service.
     * @throws Exception 
     */
    public void addEntity(womomodel.Fahrzeug entity) throws Exception {
        addEntity("/Fahrzeugs", entity);
    }

    /**
     * Creates a query for fahrzeug entities hosted by this service.
     * 
     * @param subpath
     *            The path to this entity relatively to the service URI.
     * @return A query object.
     */
    public Query<womomodel.Fahrzeug> createFahrzeugQuery(String subpath) {
        return createQuery(subpath, womomodel.Fahrzeug.class);
    }


    /**
     * Adds a new entity to the service.
     * 
     * @param entity
     *            The entity to add to the service.
     * @throws Exception 
     */
    public void addEntity(womomodel.Fahrzeug_in_saison entity) throws Exception {
        addEntity("/fahrzeug_in_saison", entity);
    }

    /**
     * Creates a query for fahrzeug_in_saison entities hosted by this service.
     * 
     * @param subpath
     *            The path to this entity relatively to the service URI.
     * @return A query object.
     */
    public Query<womomodel.Fahrzeug_in_saison> createFahrzeug_in_saisonQuery(String subpath) {
        return createQuery(subpath, womomodel.Fahrzeug_in_saison.class);
    }


    /**
     * Adds a new entity to the service.
     * 
     * @param entity
     *            The entity to add to the service.
     * @throws Exception 
     */
    public void addEntity(womomodel.Kunde entity) throws Exception {
        addEntity("/Kundes", entity);
    }

    /**
     * Creates a query for kunde entities hosted by this service.
     * 
     * @param subpath
     *            The path to this entity relatively to the service URI.
     * @return A query object.
     */
    public Query<womomodel.Kunde> createKundeQuery(String subpath) {
        return createQuery(subpath, womomodel.Kunde.class);
    }


    /**
     * Adds a new entity to the service.
     * 
     * @param entity
     *            The entity to add to the service.
     * @throws Exception 
     */
    public void addEntity(womomodel.Mietfahrzeug entity) throws Exception {
        addEntity("/Mietfahrzeugs", entity);
    }

    /**
     * Creates a query for mietfahrzeug entities hosted by this service.
     * 
     * @param subpath
     *            The path to this entity relatively to the service URI.
     * @return A query object.
     */
    public Query<womomodel.Mietfahrzeug> createMietfahrzeugQuery(String subpath) {
        return createQuery(subpath, womomodel.Mietfahrzeug.class);
    }


    /**
     * Adds a new entity to the service.
     * 
     * @param entity
     *            The entity to add to the service.
     * @throws Exception 
     */
    public void addEntity(womomodel.Saison entity) throws Exception {
        addEntity("/Saisons", entity);
    }

    /**
     * Creates a query for saison entities hosted by this service.
     * 
     * @param subpath
     *            The path to this entity relatively to the service URI.
     * @return A query object.
     */
    public Query<womomodel.Saison> createSaisonQuery(String subpath) {
        return createQuery(subpath, womomodel.Saison.class);
    }


    /**
     * Adds a new entity to the service.
     * 
     * @param entity
     *            The entity to add to the service.
     * @throws Exception 
     */
    public void addEntity(womomodel.Standort entity) throws Exception {
        addEntity("/Standorts", entity);
    }

    /**
     * Creates a query for standort entities hosted by this service.
     * 
     * @param subpath
     *            The path to this entity relatively to the service URI.
     * @return A query object.
     */
    public Query<womomodel.Standort> createStandortQuery(String subpath) {
        return createQuery(subpath, womomodel.Standort.class);
    }


}