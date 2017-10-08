/**
 * Created by Serg on 08.10.2017.
 */
public interface MaincContract {

    interface IMainView {
        void show_input_data();

        void show_calculations();

        void show_map();
    }

    interface IMainPresenter {
        void open_file();

        String read_file(String abs_path);

        void parse_data(String data);

        void calculate_fly_params();

        void build_map();
    }
}
