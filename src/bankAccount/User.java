package bankAccount;

public class User {
	private long id;
	private String nom; 
	private String prenom;
	private long accountNumber;
	
	public User(long id, String nom, String prenom, long accountNumber) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.accountNumber = accountNumber;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", accountNumber=" + accountNumber + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		User other = (User) obj;
		if(this.id == other.id && this.accountNumber == other.accountNumber
			&& this.nom.equalsIgnoreCase(other.nom) 
			&& this.prenom.equalsIgnoreCase(other.prenom)){
			return true;
		}
		return false;
	}
	
}
