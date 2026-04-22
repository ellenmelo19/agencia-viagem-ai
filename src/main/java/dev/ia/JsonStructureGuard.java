package dev.ia;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.guardrail.OutputGuardrail;
import dev.langchain4j.guardrail.OutputGuardrailResult;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JsonStructureGuard implements OutputGuardrail {
    @Override
    public OutputGuardrailResult validate(AiMessage aiMessage) {
        String response = aiMessage.text();
        try {
            JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
            return success();
        } catch (Exception e) {
            return reprompt(
                    aiMessage.text(),
                    "Erro: sua resposta nao e um JSON valido. Problema encontrado: "
                            + e.getMessage()
                            + ". Gere novamente apenas o JSON, sem blocos de codigo markdown ou texto adicional."
            );
        }
    }
}
