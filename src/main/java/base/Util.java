package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static String formatCpf(String cpf) {
        int len = cpf.length();
        for (int i = 0; i < 11 - len; i++) {
            cpf += '0';
        }
        Pattern pattern = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");
        Matcher matcher = pattern.matcher(cpf);
        if (matcher.matches()) cpf = matcher.replaceAll("$1.$2.$3-$4");
        len += Math.floor((len - 1) / 3.0);
        return cpf.substring(0, len);
    }

    public static String formatCep(String cep) {
        int len = cep.length();
        for (int i = 0; i < 8 - len; i++) {
            cep += '0';
        }
        Pattern pattern = Pattern.compile("(\\d{5})(\\d{3})");
        Matcher matcher = pattern.matcher(cep);
        if (matcher.matches()) cep = matcher.replaceAll("$1-$2");
        len += len > 5 ? 1 : 0;
        return cep.substring(0, len);
    }

    public static String formatCelular(String celular) {
        int len = celular.length();
        for (int i = 0; i < 11 - len; i++) {
            celular += '0';
        }
        Pattern pattern = Pattern.compile("(\\d{2})(\\d{5})(\\d{4})");
        Matcher matcher = pattern.matcher(celular);
        if (matcher.matches()) celular = matcher.replaceAll("($1) $2-$3");
        len += 1 + (len > 2 ? 2 : 0) + (len > 7 ? 1 : 0);
        return celular.substring(0, len);
    }

    public static String randomChoiceNotEquals(String color, List<String> coresDiponiveis) {
        ArrayList<String> cores = new ArrayList<>(coresDiponiveis);
        cores.remove(color);
        int num = new Random().nextInt(cores.size());
        return cores.get(num);
    }
}
