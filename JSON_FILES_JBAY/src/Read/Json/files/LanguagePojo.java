package Read.Json.files;

public class LanguagePojo {

	public String identifier;
	public String language;
	public Long fontSize;
	public Long textAlignment;
	public String fontName;
	public Long maxChar;
	public Long maxLine;
	public Object width;
	public Object height;

	public LanguagePojo(String identifier, String language, Long fontSize, Long textAlignment, String fontName,
			Long maxChar, Long maxLine, Object width, Object height) {
		this.identifier = identifier;
		this.language = language;
		this.fontSize = fontSize;
		this.textAlignment = textAlignment;
		this.fontName = fontName;
		this.maxChar = maxChar;
		this.maxLine = maxLine;
		this.width = width;
		this.height = height;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getFontSize() {
		return fontSize;
	}

	public void setFontSize(Long fontSize) {
		this.fontSize = fontSize;
	}

	public Long getTextAlignment() {
		return textAlignment;
	}

	public void setTextAlignment(Long textAlignment) {
		this.textAlignment = textAlignment;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public Long getMaxChar() {
		return maxChar;
	}

	public void setMaxChar(Long maxChar) {
		this.maxChar = maxChar;
	}

	public Long getMaxLine() {
		return maxLine;
	}

	public void setMaxLine(Long maxLine) {
		this.maxLine = maxLine;
	}

	public Object getWidth() {
		return width;
	}

	public void setWidth(Object width) {
		this.width = width;
	}

	public Object getHeight() {
		return height;
	}

	public void setHeight(Object height) {
		this.height = height;
	}
}