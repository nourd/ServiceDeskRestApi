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
@Table(name = "priorities")
public class Priority extends Classificator implements Serializable {

}