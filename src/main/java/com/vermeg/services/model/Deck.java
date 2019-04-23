package com.vermeg.services.model;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "deck_t")

public class Deck extends AbstractEntity {

  public Deck() {
		super();
		// TODO Auto-generated constructor stub
	}

public Deck(@NotNull @Size(min = 3, max = 32) String name, Set<Card> cards, Set<Plannification> plannification) {
		super();
		this.name = name;
		this.cards = cards;
		this.plannification = plannification;
	}

//region Data
  @Column(nullable = false, unique = true, length = 32)
  @NotNull
  @Size(min = 3, max = 32)
  private String name;
  //end region

  //region Mappings
  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
  @JoinColumn(name = "deck_id", nullable = false)
  @OrderBy("level asc")
  private Set<Card> cards = new LinkedHashSet<>();

  @OneToMany(mappedBy = "deck")
  @OrderBy("id desc")
  private Set<Plannification> plannification = new LinkedHashSet<>();
  //end region

  //region Methods
  public boolean containsCardWithValue(String cardValue) {
    return cards.stream()
        .map(Card::getValue)
        .collect(Collectors.toSet())
        .contains(cardValue);
  }

  public void removeAllCards() {
    cards.clear();
  }
  //end region

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Set<Card> getCards() {
	return cards;
}

public void setCards(Set<Card> cards) {
	this.cards = cards;
}

public Set<Plannification> getPlannification() {
	return plannification;
}

public void setPlannification(Set<Plannification> plannification) {
	this.plannification = plannification;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cards == null) ? 0 : cards.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((plannification == null) ? 0 : plannification.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Deck other = (Deck) obj;
	if (cards == null) {
		if (other.cards != null)
			return false;
	} else if (!cards.equals(other.cards))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (plannification == null) {
		if (other.plannification != null)
			return false;
	} else if (!plannification.equals(other.plannification))
		return false;
	return true;
}

}
	

