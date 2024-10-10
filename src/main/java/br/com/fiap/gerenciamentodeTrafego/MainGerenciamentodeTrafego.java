package br.com.fiap.gerenciamentodeTrafego;

import br.com.fiap.gerenciamentodeTrafego.model.EmpresaTerceira;
import br.com.fiap.gerenciamentodeTrafego.model.Semaforo;
//import br.com.fiap.gerenciamentodeTrafego.service.EmailService;
//import br.com.fiap.gerenciamentodeTrafego.service.EmpresaTerceiraService;
//import br.com.fiap.gerenciamentodeTrafego.service.SemaforoService;
//import br.com.fiap.gerenciamentodeTrafego.service.WeatherService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class MainGerenciamentodeTrafego {

    @Autowired
    private SemaforoService semaforoService;

   //@Autowired
    //private EmailService emailService;

    @Autowired
    private EmpresaTerceiraService empresaTerceiraService;

    @Autowired
    private WeatherService weatherService;

    public static void main(String[] args) {
        SpringApplication.run(MainGerenciamentodeTrafego.class, args);
    }

    @PostConstruct
    public void run() {
        // Create Semaforo objects and initialize data
        Semaforo semaforo1 = new Semaforo();
        semaforo1.setId(2L);
        semaforo1.setLocalizacao("Santa Terezinha");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.DECEMBER, 30);
        Date date = calendar.getTime();

        semaforo1.setDataUltimoReparo(date);
        semaforo1.setEstadoFisico("Bem conservado.");

        Semaforo semaforo2 = new Semaforo();
        semaforo2.setLocalizacao("Jardim Europa");

        calendar.set(2023, Calendar.APRIL, 19);
        Date date2 = calendar.getTime();

        semaforo2.setDataUltimoReparo(date2);
        semaforo2.setEstadoFisico("Más condições.");

        // Save Semaforos
        //semaforoService.saveSemaforo(semaforo1);
        //semaforoService.saveSemaforo(semaforo2);

        // Verifica e envia email de Semaforo
        verificarEEnviarEmail(semaforo1);
        verificarEEnviarEmail(semaforo2);

        // Previsão do tempo
         Map<String, Object> weatherData = weatherService.getWeather("Sao Paulo");
        System.out.println("Previsão do tempo em São Paulo: " + weatherData);
    }

    private void verificarEEnviarEmail(Semaforo semaforo) {
        String estadoFisico = semaforo.getEstadoFisico().toLowerCase();

        if (estadoFisico.contains("ruim") || estadoFisico.contains("péssimo") ||
                estadoFisico.contains("má") || estadoFisico.contains("más")) {

            List<EmpresaTerceira> empresasTerceiras = empresaTerceiraService.getAllEmpresasTerceiras();

            if (!empresasTerceiras.isEmpty()) {
                EmpresaTerceira empresaTerceira = empresasTerceiras.get(0); // Select the first company in the list

                String to = empresaTerceira.getEmailAbreChamado();
                String subject = "Solicitação de reparo no semáforo";
                String text = "O semáforo localizado em " + semaforo.getLocalizacao() + " está em " + semaforo.getEstadoFisico() + " e precisa de reparos.";

               // emailService.sendEmail(to, subject, text);
            }
        }
    }
}
