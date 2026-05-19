CREATE TABLE IF NOT EXISTS сырые_события_университета (
    идентификатор BIGSERIAL PRIMARY KEY,
    фио_преподавателя VARCHAR(200) NOT NULL,
    дисциплина VARCHAR(200) NOT NULL,
    аудитория VARCHAR(50) NOT NULL,
    дата_события TIMESTAMP NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_фио_преподавателя ON сырые_события_университета(фио_преподавателя);
CREATE INDEX IF NOT EXISTS idx_дата_события ON сырые_события_университета(дата_события);
CREATE INDEX IF NOT EXISTS idx_аудитория ON сырые_события_университета(аудитория);