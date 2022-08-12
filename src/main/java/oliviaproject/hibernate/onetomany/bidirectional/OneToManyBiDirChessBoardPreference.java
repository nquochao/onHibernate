package oliviaproject.hibernate.onetomany.bidirectional;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author HaoNguyen
 * this is the best setup. we rely on onetomany and manytoone with mappedby field.
 */
@Entity
public class OneToManyBiDirChessBoardPreference {
	@Id
	@GeneratedValue
	Integer id;

	String colorTileWhite;
	String colorTileBlack;
	String colorPieceWhite;
	String colorPieceBlack;
	int chesswidth;
	@ManyToOne(fetch = FetchType.LAZY)
	private OneToManyBiDirUserName userName;

	public OneToManyBiDirUserName getUserName() {
		return userName;
	}

	public void setUserName(OneToManyBiDirUserName userName) {
		this.userName = userName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColorTileWhite() {
		return colorTileWhite;
	}

	public void setColorTileWhite(String colorTileWhite) {
		this.colorTileWhite = colorTileWhite;
	}

	public String getColorTileBlack() {
		return colorTileBlack;
	}

	public void setColorTileBlack(String colorTileBlack) {
		this.colorTileBlack = colorTileBlack;
	}

	public String getColorPieceWhite() {
		return colorPieceWhite;
	}

	public void setColorPieceWhite(String colorPieceWhite) {
		this.colorPieceWhite = colorPieceWhite;
	}

	public String getColorPieceBlack() {
		return colorPieceBlack;
	}

	public void setColorPieceBlack(String colorPieceBlack) {
		this.colorPieceBlack = colorPieceBlack;
	}

	public int getChesswidth() {
		return chesswidth;
	}

	public void setChesswidth(int chesswidth) {
		this.chesswidth = chesswidth;
	}
}
