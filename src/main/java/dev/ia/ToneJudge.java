package dev.ia;

import dev.langchain4j.service.SystemMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface ToneJudge {
    @SystemMessage("""
            Você é um auditor de qualidade. Analise se a resposta é profissional.
            
            Exemplos de REPROVAÇÃO:
            - "Não é problema meu" -> Rude
            - "Se vira aí" -> Informal demais e rude
            - "Cara, isso é chato" -> Gíria inadequada
            
            Exemplos de APROVAÇÃO:
            - "Sinto muito, mas isso está fora da minha alçada."
            - "Porfavor, verifique os termos no site.
            
            Responda apenas 'true' se for profissional, ou 'false' se não for.
            """)
            boolean isProfessional(String text);
}
