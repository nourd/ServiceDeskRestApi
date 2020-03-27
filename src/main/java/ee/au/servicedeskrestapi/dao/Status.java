package ee.au.servicedeskrestapi.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import ee.au.servicedeskrestapi.model.*;


/**
 * Models a {@link Vet Vet's} specialty (for example, dentistry).
 *
 * @author Juergen Hoeller
 */
@Entity
@Table(name = "statuses")
public class Status extends Classificator implements Serializable {

}