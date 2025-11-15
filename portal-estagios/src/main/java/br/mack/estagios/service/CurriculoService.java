package br.mack.estagios.service;

import br.mack.estagios.dao.EstudanteDAO;
import br.mack.estagios.model.Estudante;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class CurriculoService {

    private final EstudanteDAO estudanteDAO;

    public CurriculoService(EstudanteDAO estudanteDAO) {
        this.estudanteDAO = estudanteDAO;
    }

    public byte[] gerarCurriculo(Long idEstudante) throws Exception {
        Estudante est = estudanteDAO.findById(idEstudante)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado"));

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        Document pdf = new Document();
        PdfWriter.getInstance(pdf, output);

        pdf.open();

        Font titulo = new Font(Font.HELVETICA, 20, Font.BOLD);
        Font normal = new Font(Font.HELVETICA, 12, Font.NORMAL);

        pdf.add(new Paragraph("Currículo do Estudante", titulo));
        pdf.add(new Paragraph(" "));

        pdf.add(new Paragraph("Nome: " + est.getNome(), normal));
        pdf.add(new Paragraph("Curso: " + est.getCurso(), normal));
        pdf.add(new Paragraph("E-mail: " + est.getEmail(), normal));
        pdf.add(new Paragraph("Telefone: " + est.getTelefone(), normal));
        pdf.add(new Paragraph(" "));

        pdf.add(new Paragraph("Áreas de Interesse:", new Font(Font.HELVETICA, 14, Font.BOLD)));

        for (var area : est.getInteresses()) {
            pdf.add(new Paragraph("- " + area.getTitulo(), normal));
        }

        pdf.close();

        return output.toByteArray();
    }
}